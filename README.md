# regurgitator-extensions-mq-json

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](http://github.com/talmeym/regurgitator-core-json#json-configuration-of-regurgitator)

## extension mq steps in json

### create-jms-response

a create-jms-response step returns a response from regurgitator, allowing ``response-metadata`` parameters to be set for ``jms-destination``, ``correlation-id`` and ``jms-type``:

```json
{
    "kind": "create-jms-response",
    "name": "jms-response-creator",
    "source": "response-param",
    "jms-message-id": "messageid",
    "jms-type": "my-jms-type",
    "jms-destination: "queue://my-destination",
    "jms-correlation-id": "52908d79-b7c6-4e18-ab13-e991d1b67d8b",
    "jms-delivery-mode": 4,
    "jms-expiration": "",
    "jms-redelivered": true,
    "jms-priority": "",
    "jms-reply-to": "queue://other-destination",
    "jms-timestamp: 123456789
}
```
