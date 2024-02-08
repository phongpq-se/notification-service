CREATE TABLE IF NOT EXISTS ppq_notifications.notification_template(
templateId text,
type text,
ver text,
data text,
template_schema text,
config map<text,text>,
createdBy text,
createdOn timestamp,
lastUpdatedBy text,
lastUpdatedOn timestamp,
PRIMARY KEY(templateId)
);