CREATE TABLE IF NOT EXISTS ppq_notifications.notification_feed (
    id text ,
    userid text,
    version text,
    status text,
    action text,
    priority int,
    expireOn timestamp,
    createdBy text,
    createdOn timestamp,
    updatedBy text,
    updatedOn timestamp,
    primary key(userid,id)
);

CREATE TABLE IF NOT EXISTS ppq_notifications.notification_template(
    templateId text,
    type text,
    ver text,
    data text,
    templateSchema text,
    config map<text,text>,
    createdBy text,
    createdOn timestamp,
    lastUpdatedBy text,
    lastUpdatedOn timestamp,
    PRIMARY KEY(templateId)
);