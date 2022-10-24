const express = require('express');
const app = express();
const http = require('http').Server(app)
const io = require('socket.io')(http)
    // var user = document.URL;
const url = require('url');
let params = "";



app.use('/style', express.static(__dirname + '/style'))
app.get('/?username=:username&id=:id', function(req, res) {
    user = req.params.username;
    id = req.params.id;
    console.log(id);
    params = user;
    // console.log(req.params.username);
    // res.send("Username is set to " + params)
    res.sendFile(__dirname + '/index.html')
});



io.on('connection', (socket) => {
    socket.username = params;
    // console.log(search_params);
    socket.on('message', (msg) => io.emit('message', { 'user': socket.username, 'message': msg }))
    socket.on('join', (username) => {
        if (username != null) {
            socket.username = username
        }
        socket.broadcast.emit('message', { user: 'Server', 'message': socket.username + " has joined the server !" })
    })
})

http.listen(3001, () => console.log('Listening on port 3001!'))
    // module.exports = { params }