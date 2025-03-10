# regurgitator-extensions-mq-json

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](https://talmeym.github.io/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](https://talmeym.github.io/regurgitator-core-json#json-configuration-of-regurgitator)

## extension mq steps in json

### jms-call

a jms-call step make an outward jms call

```json
{
  "kind": "jms-call",
  "destination": "queue://queue-name"
}
```

while destination is specified in the json, all other attributes of the call are set from parameters within the message object, as listed below:

|context|parameter|call attribute|default (if not specified)|
|:---|:---|:---|:---|
|``request-metadata``|``jms-message-id``|jms message id|not set|
|``request-metadata``|``jms-type``|jms type|not set|
|``request-metadata``|``jms-destination``|jms destination|not set|
|``request-metadata``|``jms-correlation-id``|jms correlation id|not set|
|``request-metadata``|``jms-delivery-mode``|jms delivery mode|not set|
|``request-metadata``|``jms-expiration``|expiration|not set|
|``request-metadata``|``jms-priority``|jms priority|not set|
|``request-metadata``|``jms-redelivered``|jms redelivered|not set|
|``request-metadata``|``jms-reply-to``|jms reply to|not set|
|``request-metadata``|``jms-timestamp``|jms timestamp|not set|
|``request-properties``| ``[property name]`` |object property|not set|
|``request-payload``|``text`` |payload|not set|

#### jms proxy

if using the ``MqMessageBridge`` to mock over jms, a ``jms-call`` step not placed within an isolated sequence will, upon execution, be given a message object that already contains the ``request-metadata`` context from the incoming jms message, and will therefore act as a jms proxy, creating an outgoing jms message identical to the one received by the ``MqMessageListener``, except 'redirected' to a new destination. this is useful for forwarding on any jms messages you wish not to act upon.

If instead you wish the ``jms-call`` step to create an independent jms message, then the step should be placed within an isolated sequence, and should be proceeded by ``create-parameter`` steps to set the necessary jms message attributes.

```json
{
  "kind": "sequence",
  "isolate": "true",
  "steps": [
    {
      "kind": "create-parameter",
      "name": "request-payload:text",
      "value": "<message>this is my message content</message>"
    },
    {
      "kind": "create-parameter",
      "name": "request-metadata:jms-reply-to",
      "value": "queue://other-queue-name"
    },
    {
      "kind": "create-parameter",
      "name": "request-metadata:jms-expiration",
      "value": "36000",
      "type": "NUMBER"
    },
    {
      "kind": "jms-call",
      "destination": "queue://something"
    }
  ]
}
```

### create-jms-response

a create-jms-response step returns a response from regurgitator, allowing ``response-metadata`` parameters to be set, e.g. ``jms-destination``, ``jms-correlation-id`` and ``jms-type``:

```json
{
    "kind": "create-jms-response",
    "source": "response-param",
    "jms-message-id": "message-id",
    "jms-type": "my-jms-type",
    "jms-destination": "queue://my-destination",
    "jms-correlation-id": "52908d79-b7c6-4e18-ab13-e991d1b67d8b",
    "jms-delivery-mode": 1,
    "jms-expiration": 1506253192636,
    "jms-redelivered": true,
    "jms-priority": 4,
    "jms-reply-to": "queue://other-destination",
    "jms-timestamp": 1506253192636
}
```

---

api docs: [``0.1.4``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-mq-json/0.1.4/){:target="_blank"} [``0.1.3``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-mq-json/0.1.3/){:target="_blank"} [``0.1.2``](https://regurgitator.emarte.uk/apidocs/regurgitator-extensions-mq-json/0.1.2/){:target="_blank"}
