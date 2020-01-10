package com.tudou.base.menu.service.impl;

import com.tudou.base.menu.entity.Items;
import com.tudou.extra.system.AuthInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.tudou.base.menu.service.IEidpMenuService;
import com.tudou.base.menu.mapper.EidpMenuMapper;
import com.tudou.system.platform.base.service.impl.BaseServiceImpl;
import com.tudou.base.menu.entity.EidpMenu;
import org.springframework.transaction.annotation.Transactional;
import com.tudou.system.platform.base.annotation.BaseResource;

import java.util.*;

@Transactional(rollbackFor = Exception.class)
@Service("eidpMenuService")
public class EidpMenuServiceImpl extends BaseServiceImpl<EidpMenu, String> implements IEidpMenuService {

    @Resource
    @BaseResource
    private EidpMenuMapper eidpMenuMapper;

    @Override
    public List<Items> getMenus() throws Exception {
        List<EidpMenu> eidpMenus = eidpMenuMapper.findAllMenusByLevel(1);
        List<Items> items = buiderChildItems(eidpMenus, null);
        return items;
    }


    @Override
    public List<Items> getMenusByEmp(AuthInfo authInfo) throws Exception {
        List<EidpMenu> eidpMenus = eidpMenuMapper.findMenuByEmpIdAndOrganizationId(authInfo.getEmpId(), authInfo.getDepartment());
        // 查询到最顶层的菜单
        Set<EidpMenu> menus = new HashSet<EidpMenu>();
        EidpMenu eidpMenu = null;
        for (EidpMenu menu : eidpMenus) {
            eidpMenu = menu;
            while (eidpMenu.getParentMenu() != null) {
                eidpMenu = eidpMenu.getParentMenu();
            }
            menus.add(eidpMenu);
        }
        List<Items> items = buiderChildItems(menus, eidpMenus);
        return items;
    }

    /**
     * 构建子菜单
     *
     * @param eidpMenus
     * @return
     */
    private List<Items> buiderChildItems(Collection<EidpMenu> eidpMenus, Collection<EidpMenu> oldMenus) {
        List<Items> items = new ArrayList<Items>();
        Items item = null;
        for (EidpMenu menu : eidpMenus) {
            if (CollectionUtils.isNotEmpty(oldMenus) && menu.getParentId() != null) {
                boolean isContinue = false;
                // 如果该节点的父节点和传递过来的旧菜单父节点相同。说明是兄弟节点 跳过
                for (EidpMenu m : oldMenus) {
                    if (m.getParentId() != null && m.getParentId().equals(menu.getParentId())) {
                        isContinue = true;
                        break;
                    }
                }
                if (isContinue) {
                    continue;
                }
            }
            item = new Items();
            if (CollectionUtils.isNotEmpty(menu.getChildMenus())) {
                item.setItems(buiderChildItems(menu.getChildMenus(), oldMenus));
            }
            if (StringUtils.isNotEmpty(menu.getUrl())) {
                item.setUrl("javascript:addTab(\"" + menu.getText() + "\",\"" + menu.getUrl() + "\")");
            }
            if (StringUtils.isNotEmpty(menu.getIcon())) {
                item.setText("<span class='" + menu.getIcon() + "'></span> " + menu.getText());
            } else {
                item.setText(menu.getText());
            }
            item.setEncoded(false);
            items.add(item);
        }
        return items;
    }

}