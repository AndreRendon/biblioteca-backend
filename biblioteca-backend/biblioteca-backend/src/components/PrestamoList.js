// src/components/PrestamoList.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function PrestamoList() {
    const [prestamos, setPrestamos] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/prestamos')
            .then(response => {
                setPrestamos(response.data);
            })
            .catch(error => {
                console.error('Hubo un error!', error);
            });
    }, []);

    return (
        <div>
            <h1>Préstamos</h1>
            <ul>
                {prestamos.map(prestamo => (
                    <li key={prestamo.id}>Libro: {prestamo.libro.titulo} - Usuario: {prestamo.usuario.nombre}</li>
                ))}
            </ul>
        </div>
    );
}

export default PrestamoList;
function agregarPrestamo(nuevoPrestamo) {
  axios.post('http://localhost:8080/api/usuarios', nuevoPrestamo)
    .then(response => {
      // Actualizar la lista de prestamos
    })
    .catch(error => {
      console.error('Hubo un error al agregar el prestamo!', error);
    });
}
