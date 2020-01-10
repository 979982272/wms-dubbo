#!/bin/sh

## java env
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.161-0.b14.el7_4.x86_64
export JRE_HOME=$JAVA_HOME/jre

## service name
APP_NAME=wms-base-crm-service-1.0-SNAPSHOT

SERVICE_DIR=/usr/local/wms-server/service
JAR_NAME=$APP_NAME\.jar
PID=$APP_NAME\.pid

cd $SERVICE_DIR

case "$1" in

    start)
        nohup $JRE_HOME/bin/java -Xms256m -Xmx512m -jar $JAR_NAME >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $APP_NAME"
        ;;

    stop)
        kill `cat $SERVICE_DIR/$PID`
        rm -rf $SERVICE_DIR/$PID
        echo "=== stop $APP_NAME"

        sleep 5
        P_ID=`ps -ef | grep -w "$APP_NAME" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $APP_NAME process not exists or stop success"
        else
            echo "=== $APP_NAME process pid is:$P_ID"
            echo "=== begin kill $APP_NAME process, pid is:$P_ID"
            kill -9 $P_ID
        fi
        ;;

    restart)
        $0 stop
        sleep 2
        $0 start
        echo "=== restart $SERVICE_NAME"
        ;;
	log)
       tail -f $SERVICE_DIR/logs/crm/wms-base-crm.log
        ;;
    *)
        ## restart
        nohup $JRE_HOME/bin/java -Xms256m -Xmx512m -jar $JAR_NAME >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $APP_NAME"
        ;;

esac
exit 0

