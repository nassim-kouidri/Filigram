let app = require('express')();

let http = require('http').Server(app);

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.vue');
})

http.listen(3000, () => {
    console.log('Connected done')
})