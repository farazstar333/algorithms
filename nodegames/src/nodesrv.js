/**
 * Created by farazw808 on 6/3/15.
 */
var http = require('http');

var server = http.createServer(function (request, response) {
    console.log('request starting...');
    console.log('request headers...');
    console.log(request.headers);
    // respond
    response.write('hello client!');
    response.write('request headers...');
    response.write("headers we have" + request.headers);
    response.end();

});

server.listen(3000);
console.log('Server running at http://127.0.0.1:3000/');
