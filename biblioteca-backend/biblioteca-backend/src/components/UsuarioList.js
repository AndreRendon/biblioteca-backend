import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Usuario() {
  const [usuarios, setUsuarios] = useState([]);
  const [nombre, setNombre] = useState('');
  const [email, setEmail] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/api/usuarios')
      .then(response => {
        setUsuarios(response.data);
      })
      .catch(error => {
        console.error('Hubo un error al obtener los usuarios!', error);
      });
  }, []);

  const agregarUsuario = () => {
    const nuevoUsuario = { nombre, email };
    axios.post('http://localhost:8080/api/usuarios', nuevoUsuario)
      .then(response => {
        setUsuarios([...usuarios, response.data]);
        setNombre('');
        setEmail('');
      })
      .catch(error => {
        console.error('Hubo un error al agregar el usuario!', error);
      });
  };

  const eliminarUsuario = (id) => {
    axios.delete(`http://localhost:8080/api/usuarios/${id}`)
      .then(() => {
        setUsuarios(usuarios.filter(usuario => usuario.id !== id));
      })
      .catch(error => {
        console.error('Hubo un error al eliminar el usuario!', error);
      });
  };

  return (
    <div>
      <h1>Usuarios</h1>
      <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} placeholder="Nombre" />
      <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" />
      <button onClick={agregarUsuario}>Agregar Usuario</button>
      <ul>
        {usuarios.map(usuario => (
          <li key={usuario.documento}>
            {usuario.nombre} ({usuario.email})
            <button onClick={() => eliminarUsuario(usuario.documento)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Usuario;
