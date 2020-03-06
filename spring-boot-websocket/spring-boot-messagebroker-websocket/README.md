## Connecting and subscribe with SockJS:

```
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

var stompClient = null;

function connect () {
  var socket = new SockJS('http://localhost:9000/ws/chat')
  stompClient = Stomp.over(socket)
  stompClient.connect({}, (frame) => {
    connected = true
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/messages', (tick) => {
      console.log(tick)
    })
  }, (error) => {
    console.log(error)
    connected = false
  })
}
```

## Sending a message:

```
var from = 'Daniel Monti';
var text = 'Hello World!';

stompClient.send('/app/chat', JSON.stringify({'from':from, 'text': text}), {})
```
