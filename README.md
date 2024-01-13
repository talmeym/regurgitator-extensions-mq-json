# regurgitator-extensions-mq-json

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](https://talmeym.github.io/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](https://talmeym.github.io/regurgitator-core-json#json-configuration-of-regurgitator)

## extension mq steps in json

### create-jms-response

a create-jms-response step returns a response from regurgitator, allowing ``response-metadata`` parameters to be set, e.g. ``jms-destination``, ``correlation-id`` and ``jms-type``:

```json
{
    "kind": "create-jms-response",
    "name": "jms-response-creator",
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
