    let openShopping = document.querySelector('.shopping');
    let closeShopping = document.querySelector('.closeShopping');
    let list = document.querySelector('.list');
    let listCard = document.querySelector('.listCard');
    let body = document.querySelector('body');
    let total = document.querySelector('.total');
    let odeme = document.querySelector('.odeme');
    let quantity = document.querySelector('.quantity');
    let popup = document.getElementById('popup');

    openShopping.addEventListener('click', () => {
        body.classList.add('active');
    });

    closeShopping.addEventListener('click', () => {
        body.classList.remove('active');
    });

    let products = [
        {
            id: 1,
            name: 'Kosta Rika Yöresel Filtre Kahve 200g',
            image: 'coffee1.jpg',
            price: 120000
        },
        {
            id: 2,
            name: 'Vanilya Aromalı Filtre Kahve 250g',
            image: 'coffee1.jpg',
            price: 120000
        },
        {
            id: 3,
            name: 'Etiyopya Yöresel Filtre Kahve 200g',
            image: 'coffee1.jpg',
            price: 220000
        },
        {
            id: 4,
            name: 'Fındık Aromalı Filtre Kahve 250g',
            image: 'coffee1.jpg',
            price: 123000
        },
        {
            id: 5,
            name: 'El Salvador Yöresel Kahve 200g',
            image: 'coffee1.jpg',
            price: 320000
        },
        {
            id: 6,
            name: 'Guatemala Yöresel Filtre Kahve 200g',
            image: 'coffee1.jpg',
            price: 120000
        }
    ];

    let listCards = [];

    function saveCartToLocalStorage() {
        localStorage.setItem('cart', JSON.stringify(listCards));
    }

    function loadCartFromLocalStorage() {
        const savedCart = JSON.parse(localStorage.getItem('cart'));
        if (savedCart) {
            listCards = savedCart;
            reloadCard();
        }
    }

    function initApp() {
        products.forEach((value, key) => {
            let newDiv = document.createElement('div');
            newDiv.classList.add('item');
            newDiv.innerHTML = `
                <img src="img/${value.image}">
                <div class="title">${value.name}</div>
                <div class="price">${value.price.toLocaleString()}</div>
                <button onclick="addToCard(${key})">Sepete Ekle</button>`;
            list.appendChild(newDiv);
        });
        loadCartFromLocalStorage();
    }
    initApp();

    function addToCard(key) {
        if (listCards[key] == null) {
            listCards[key] = JSON.parse(JSON.stringify(products[key]));
            listCards[key].quantity = 1;
        } else {
            listCards[key].quantity += 1;
            listCards[key].price = listCards[key].quantity * products[key].price;
        }
        saveCartToLocalStorage();
        reloadCard();
        showPopup();

        // AJAX 
        $.ajax({
            url: 'add_to_cart.php', // Replace with your server-side script URL
            type: 'POST',
            data: { id: products[key].id, quantity: listCards[key].quantity },
            success: function(response) {
                console.log('Product added to cart successfully.');
            },
            error: function(xhr, status, error) {
                console.error('Error adding product to cart:', error);
            }
        });
    }

    function reloadCard() {
        listCard.innerHTML = '';
        let count = 0;
        let totalPrice = 0;
        listCards.forEach((value, key) => {
            if (value != null) {
                totalPrice += value.price;
                count += value.quantity;
                let newDiv = document.createElement('li');
                newDiv.innerHTML = `
                    <div><img src="img/${value.image}"/></div>
                    <div>${value.name}</div>
                    <div>${value.price.toLocaleString()}</div>
                    <div>
                        <button onclick="changeQuantity(${key}, ${value.quantity - 1})">-</button>
                        <div class="count">${value.quantity}</div>
                        <button onclick="changeQuantity(${key}, ${value.quantity + 1})">+</button>
                    </div>`;
                listCard.appendChild(newDiv);
            }
        });
        total.innerText = totalPrice.toLocaleString();
        quantity.innerText = count;
    }

    function changeQuantity(key, quantity) {
        if (quantity == 0) {
            delete listCards[key];
        } else {
            listCards[key].quantity = quantity;
            listCards[key].price = quantity * products[key].price;
        }
        saveCartToLocalStorage();
        reloadCard();
    }

    function showPopup() {
        popup.style.display = 'block';
        setTimeout(() => {
            popup.style.display = 'none';
        }, 3000);
    }