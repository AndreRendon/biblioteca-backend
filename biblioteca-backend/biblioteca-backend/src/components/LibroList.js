import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Libro() {
  const [libros, setLibros] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/libros')
      .then(response => {
        setLibros(response.data);
      })
      .catch(error => {
        console.error('Hubo un error al obtener los libros!', error);
      });
  }, []);

  return (
    <div>
      <h1>Libros</h1>
      <ul>
        {libros.map(libro => (
          <li key={libro.id}>{libro.titulo} - {libro.autor}</li>
        ))}
      </ul>
    </div>
  );
}

export default Libro;
