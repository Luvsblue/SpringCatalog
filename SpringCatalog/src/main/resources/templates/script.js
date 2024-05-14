document.getElementById('addProductForm').addEventListener('submit', addProduct);

function addProduct(event) {
    event.preventDefault();
    
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const category = document.getElementById('category').value;

    fetch('/addProduct', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, price, category })
    })
    .then(response => {
        if (response.ok) {
            alert('Product added successfully');
            document.getElementById('name').value = '';
            document.getElementById('price').value = '';
            document.getElementById('category').value = '';
        } else {
            alert('Failed to add product');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function displayProducts() {
    fetch('/displayProducts')
    .then(response => response.json())
    .then(products => {
        const productTable = document.getElementById('productTable');
        productTable.innerHTML = '';
        const tbody = document.createElement('tbody');

        products.forEach(product => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.category}</td>
            `;
            tbody.appendChild(tr);
        });

        productTable.appendChild(tbody);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}