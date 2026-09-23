      document.addEventListener("DOMContentLoaded", function() {
            const products = [
                {
                    image: "coffee_cup.jpg",
                    title: "Kolombiya Yöresel Filtre Kahve 200g",
                    description: "French demleme yöntemine uygundur."
                },
                {
                    image: "coffee_cup.jpg",
                    title: "Brezilya Kahve Çekirdeği 250g",
                    description: "Espresso demleme yöntemine uygundur."
                },
                {
                    image: "coffee_cup.jpg",
                    title: "Etiyopya Yöresel Kahve 200g",
                    description: "Pour over demleme yöntemine uygundur."
                },
                {
                    image: "coffee_cup.jpg",
                    title: "Kenya AA Kahve Çekirdeği 200g",
                    description: "French demleme yöntemine uygundur."
                },
                {
                    image: "coffee_cup.jpg",
                    title: "Guatemala Kahve Çekirdeği 250g",
                    description: "Espresso demleme yöntemine uygundur."
                },
                {
                    image: "coffee_cup.jpg",
                    title: "Honduras Kahve Çekirdeği 200g",
                    description: "Pour over demleme yöntemine uygundur."
                }
            ];

            const itemsPerPage = 3;
            const totalPages = Math.ceil(products.length / itemsPerPage);
            const paginationContainer = document.getElementById('pagination');
            const productContainer = document.getElementById('product-container');

            function renderProducts(page) {
                productContainer.innerHTML = "";
                const start = (page - 1) * itemsPerPage;
                const end = start + itemsPerPage;
                const paginatedProducts = products.slice(start, end);

                paginatedProducts.forEach(product => {
                    const productHtml = `
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <img src="img/${product.image}" style="height: 250px;" class="card-img-top" alt="Ürün Resmi">
                                <div class="card-body">
                                    <h5 class="card-title">${product.title}</h5>
                                    <p class="card-text">${product.description}</p>
                                </div>
                            </div>
                        </div>
                    `;
                    productContainer.innerHTML += productHtml;
                });
            }

            function renderPagination() {
                paginationContainer.innerHTML = "";
                for (let i = 1; i <= totalPages; i++) {
                    const paginationItem = `
                        <li class="page-item ${i === 1 ? 'active' : ''}">
                            <a class="page-link" href="#">${i}</a>
                        </li>
                    `;
                    paginationContainer.innerHTML += paginationItem;
                }
            }

            paginationContainer.addEventListener('click', function(event) {
                if (event.target.tagName === 'A') {
                    const page = parseInt(event.target.textContent);
                    document.querySelector('.pagination .active').classList.remove('active');
                    event.target.parentElement.classList.add('active');
                    renderProducts(page);
                }
            });

            // Initial render
            renderProducts(1);
            renderPagination();
        });