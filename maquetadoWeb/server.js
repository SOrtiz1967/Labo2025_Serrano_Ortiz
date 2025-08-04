const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(__dirname)); // Para servir archivos estáticos

// Conexión a la base de datos
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'alumno',           // ← poné tu usuario de MySQL
  password: 'alumnoipm',    // ← y tu contraseña
  database: 'CentroCultural'
});

// Ruta para mostrar el formulario
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'form_validado.html'));
});

// Ruta para recibir el formulario y guardar en la base
app.post('/enviar', (req, res) => {
  const { email, nombre, edad, telefono, direccion } = req.body;

  const sql = `INSERT INTO inscipcionEvento (email, nombre, edad, telefono, direccion)
              VALUES (?, ?, ?, ?, ?)`;

  connection.query(sql, [email, nombre, edad, telefono, direccion], (err, result) => {
    if (err) {
      console.error('❌ Error al insertar:', err);
      res.status(500).send('Error al guardar los datos.');
    } else {
      console.log('✅ Datos insertados correctamente');
      //res.send('Te inscribiste correctamente, espero que disfrutes el evento.');
      //res.sendFile(path.join(__dirname,'index.html'))
      res.redirect('/index.html?mensaje=ok');
    }
  });
});

app.listen(port, () => {
  console.log(`Servidor corriendo en http://localhost:${port}`);
});

