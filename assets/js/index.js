document.addEventListener('DOMContentLoaded', function (e) {


    fetch(`http://localhost:8080/books/libros`)
        .then(response => response.json())
        .then(data => {
            mostrarResultados(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });


})


const mostrarResultados = (data) => {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = '';

    if (data) {
        data.forEach(item => {
            const libro = item;
          
            const libroElement = document.createElement('div');
            libroElement.className += "col-12 col-md-6 col-lg-4 d-flex justify-content-center"
            libroElement.innerHTML = `
                <div class="card">
                    <div class="card__side card__side--front-1">
                        ${libro.imagen ? `<img src="http://localhost:8080/books/${libro.imagen}" alt="Portada de ${libro.titulo}">` : 'No hay imagen disponible'}
                    </div>
                    <div class="card__side card__side--back card__side--back-1">
                        <div class="text">
                            <a href="detalle.html">
                                <h4>${libro.titulo}</h4>
                                <p class="titulo">
                                    ${libro.descripcion ? libro.descripcion : 'No disponible'}
                                </p>
                            </a>
                        </div>     
                    </div>
                </div> 
            `
            resultsDiv.appendChild(libroElement);
        });
    } else {
        resultsDiv.innerHTML = '<p>No se encontraron resultados</p>';
    }
}