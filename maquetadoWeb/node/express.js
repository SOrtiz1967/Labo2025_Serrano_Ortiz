const express = require('express')
const app = express()
const port = 3000
app.get('/', (req, res) => {
res.send('Hello World!')
})
app.get('/contacto', (req, res) => {
res.sendFile(__dirname+"/form.html")
})
app.get('/insertar', (req, res) => {
res.sendFile(__dirname+"/form.html")
})
app.listen(port, () => {
console.log(`Example app listening on port ${port}`)
})