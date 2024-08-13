import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Usuario from './components/Usuario';
import Libro from './components/Libro';
import Prestamo from './components/Prestamo';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/usuarios" element={<Usuario />} />
          <Route path="/libros" element={<Libro />} />
          <Route path="/prestamos" element={<Prestamo />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
