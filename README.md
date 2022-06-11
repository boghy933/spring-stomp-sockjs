# How to test

1. Open url http://localhost:8080/websocket
2. Open browser developer tools and go to console
2. Copy and paste the code for stomp from cdn => https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js inside the console
3. Copy and paste the code for sockjs cdn => https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js inside the console
4. Copy the script to connect
5. run "connectRome()" inside console
6. Check for new messages in console
7. For London do the same thing in a new tab

Script
``
function connectRome() {
    var socket = new SockJS('http://localhost:8080/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/Rome', function (greeting) {
            console.log("Received message: " . greeting)
        });
    });
}

function connectLondon() {
    var socket = new SockJS('http://localhost:8080/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/London', function (greeting) {
            console.log("Received message: " . greeting)
        });
    });
}
``