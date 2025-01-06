document.addEventListener('DOMContentLoaded', () => {
    const chickenBurger = './Asserts/burger.png';
    const Focaccia = './Asserts/Focaccia.png';
    const FrenchFries = './Asserts/FrenchFries.png';
    const JalapenoFries = './Asserts/JalapenoFries.png';
    const VegBurger = './Asserts/VegBurger.png';
    const ChocolateCake = './Asserts/ChocolateMousseCake.png'
    const RedVelvet = './Asserts/RedVelvet.png';
    const Biriyani = './Asserts/Biriyani.png';
    const ChickenTikka = './Asserts/ChickenTikka.png';
    const Icecream = './Asserts/Icecream.png';
    const MintCocktail = './Asserts/MintCocktail.png';
    const RedMocktail = './Asserts/RedMocktail.png';

    // Sample menu items and table data
    const menuItems = [
        { id: 1, image: Focaccia, name: 'Crusty Garlic Focaccia with Melted Cheese', type: 'appetizer', price: 150 },
        { id: 2, image: FrenchFries, name: 'French Fries', type: 'appetizer', price: 105 },
        { id: 3, image: ChickenTikka, name: 'Masala Chicken Tikka', type: 'appetizer', price: 200 },
        { id: 4, image: JalapenoFries, name: 'French Fries with Cheese & Jalapenos', type: 'appetizer', price: 135 },
        { id: 5, image: chickenBurger, name: 'Chicken & Cheese Burger', type: 'main', price: 220 },
        { id: 6, image: VegBurger, name: 'Veggie 9 Burger', type: 'main', price: 180 },
        { id: 7, image: Biriyani, name: 'Biriyani', type: 'main', price: 250 },
        { id: 8, image: ChocolateCake, name: 'Chocolate Mousse Cake', type: 'desserts', price: 200 },
        { id: 9, image: RedVelvet, name: 'Red Velvet Cake', type: 'desserts', price: 160 },
        { id: 10, image: Icecream, name: 'Oreo Ice Cream Sundae', type: 'desserts', price: 350 },
        { id: 11, image: MintCocktail, name: 'Tasty Mint Julep Cocktail', type: 'beverages', price: 150 },
        { id: 12, image: RedMocktail, name: 'Red Mocktail with Cherries', type: 'beverages', price: 200 }
    ];

    const tables = [
        { id: 1, name: 'Table' },
        { id: 2, name: 'Table' },
        { id: 3, name: 'Table' },
    ];

    const orders = {}; // To store orders for each table

    // Elements from the DOM
    const menuItemsContainer = document.getElementById('menuItems');
    const tablesContainer = document.getElementById('tables');
    const orderModal = document.getElementById('orderModal');
    const closeModal = document.getElementsByClassName('close')[0];
    const orderDetails = document.getElementById('orderDetails');
    const generateBillButton = document.getElementById('generateBill');
    const tableSearchInput = document.getElementById('tableSearch');
    const menuSearchInput = document.getElementById('menuSearch');

    const addTableButton = document.getElementById('addTableButton');
    const tableAddModel = document.getElementById('tableAddModel');
    const closeTableAddModel = document.getElementsByClassName('tableAddClose')[0];
    const addTableForm = document.getElementById('addTableForm');

    const tableOrdersHead = document.getElementById('tableOrdersHead');

    const tableSearch = document.getElementById('tableSearchBar');
    const menuSearch = document.getElementById('menuSearchBar');
    const clearTableSearch = document.getElementById('clearTableSearch');
    const clearMenuSearch = document.getElementById('clearMenuSearch');

    // Render menu items
    function renderMenuItems(items) {
        menuItemsContainer.innerHTML = '';
        items.forEach(item => {
            const div = document.createElement('div');
            div.className = 'menu-item';
            div.draggable = true;
            div.dataset.id = item.id;
            div.innerHTML = `
                <img src="${item.image}" alt="${item.name}" draggable="true" data-id="${item.id}">
                <h2>${item.name}</h2>
                <div class="price">Rs. ${item.price}</div>
            `;
            menuItemsContainer.appendChild(div);
        });
    }

    // Render tables
    function renderTables(tables) {
        tablesContainer.innerHTML = '';
        tables.forEach(table => {
            const div = document.createElement('div');
            div.className = 'table';
            div.dataset.id = table.id;
            updateTableDiv(div, table.id, table.name);
            tablesContainer.appendChild(div);
        });
    }

    // Update table information
    function updateTableDiv(div, tableId, tableName) {
        const tableOrders = orders[tableId] || {};
        const totalItems = Object.values(tableOrders).reduce((acc, order) => acc + order.quantity, 0);
        const totalPrice = Object.values(tableOrders).reduce((acc, order) => acc + (order.quantity * order.price), 0);
        div.innerHTML = `
        <h2>${tableName} - ${tableId}</h2>
        <div>Rs. ${totalPrice} | Total items: ${totalItems}</div>
        `;
    }

    // Update order for a table
    function updateOrder(tableId, itemId, quantity) {
        if (!orders[tableId]) {
            orders[tableId] = {};
        }

        if (!orders[tableId][itemId]) {
            const menuItem = menuItems.find(item => item.id === parseInt(itemId));
            orders[tableId][itemId] = { quantity: 0, price: menuItem.price, name: menuItem.name };
        }

        orders[tableId][itemId].quantity += quantity;

        if (orders[tableId][itemId].quantity <= 0) {
            delete orders[tableId][itemId];
        }

        renderTableOrders(tableId);
        renderTables(tables);
    }

    // Render order details in the modal
    function renderTableOrders(tableId) {
        orderDetails.innerHTML = '';
        const getTableName = (tableId) => {
            const table = tables.filter((table) => table.id === Number(tableId));
            return table[0].name;
        }
        const getMenuImage = (name) => {
            const item = menuItems.filter((item) => item.name === name);
            return item[0].image;
        }
        const tableName = getTableName(tableId);
        tableOrdersHead.innerHTML = `${tableName} - ${tableId} | Order Details`;
        const tableOrders = orders[tableId];
        let totalAmount = 0;
        const titles = document.createElement('div');
        titles.className = 'orders-format-main';
        titles.innerHTML = `
            <p>Item</p>
            <p>Name</p>
            <p>Price</p>
            <p>Quantity</p>
            <p>Remove</p>
        `;
        orderDetails.appendChild(titles);

        const orderItems = document.createElement('div');
        orderItems.className = 'orderItems';
        if (tableOrders) {
            Object.keys(tableOrders).forEach(itemId => {
                const order = tableOrders[itemId];
                const items = document.createElement('div');
                items.className = 'orders-format orders-format-main';
                const image = getMenuImage(order.name);
                totalAmount += order.quantity * order.price;
                items.innerHTML = `
                <img src="${image}" alt="${order.name}" class='orders-product-icon'>
                <p>${order.name}</p>
                <p>${(order.price * order.quantity).toFixed(2)}</p>
                <div class="quantity"><input type="number" value="${order.quantity}" data-table="${tableId}" data-item="${itemId}"></div>
                <i class="fa-solid fa-trash orders-remove-icon" onclick="removeOrderItem(${tableId}, ${itemId})"></i>
            `;
                orderItems.appendChild(items);
            });
        }
        orderDetails.appendChild(orderItems);
        const totalDiv = document.createElement('div');
        totalDiv.className = 'order-total';
        totalDiv.innerHTML = `Total: Rs. ${totalAmount.toFixed(2)}`;
        orderDetails.appendChild(totalDiv);
        if (!tableOrders || Object.keys(tableOrders).length == 0)
            generateBillButton.setAttribute("disabled", "");
        else
            generateBillButton.removeAttribute("disabled");
    }
    // Remove order item
    window.removeOrderItem = function (tableId, itemId) {
        delete orders[tableId][itemId];
        renderTableOrders(tableId);
        renderTables(tables);
    };

    // Show order modal
    function showOrderModal(tableId) {
        renderTableOrders(tableId);
        orderModal.style.display = 'block';
    }

    // Close modal event handlers
    closeModal.onclick = () => {
        orderModal.style.display = 'none';
    };

    window.onclick = event => {
        if (event.target == orderModal) {
            orderModal.style.display = 'none';
        }
        if (event.target == tableAddModel) {
            tableAddModel.style.display = 'none';
        }
    };

    // Initial render
    renderMenuItems(menuItems);
    renderTables(tables);

    // Event listeners for drag-and-drop
    menuItemsContainer.addEventListener('dragstart', event => {
        if (event.target.tagName === 'IMG') {
            event.dataTransfer.setData('text/plain', event.target.dataset.id);
        }
        event.dataTransfer.setData('text/plain', event.target.dataset.id);
    });

    tablesContainer.addEventListener('dragover', event => {
        event.preventDefault();
    });

    tablesContainer.addEventListener('drop', event => {
        event.preventDefault();
        const itemId = event.dataTransfer.getData('text/plain');
        const table = event.target.closest('.table');
        const tableId = table.dataset.id;
        if (tableId) {
            updateOrder(tableId, itemId, 1);
        }
    });

    // Show order modal on table click
    tablesContainer.addEventListener('click', event => {
        const tableId = event.target.closest('.table').dataset.id;
        if (tableId) {
            showOrderModal(tableId);
        }
    });

    // Update order quantity from modal
    orderDetails.addEventListener('input', event => {
        if (event.target.type === 'number') {
            const tableId = event.target.dataset.table;
            const itemId = event.target.dataset.item;
            const quantity = parseInt(event.target.value);
            const currentQuantity = orders[tableId][itemId].quantity;
            updateOrder(tableId, itemId, quantity - currentQuantity);
        }
    });

    // Generate bill button click handler
    generateBillButton.onclick = () => {
        if (confirm("Are you sure you want to checkout?")) {
            const tableText = tableOrdersHead.textContent.split('|')[0].trim(); // Extract table name and ID
            const tableIdMatch = tableText.match(/(\d+)$/); // Match the table ID at the end of the string
            const tableId = tableIdMatch ? parseInt(tableIdMatch[0].trim()) : null; // Extract the table ID
            const tableName = tableText.split('-')[0].trim();
            const tableOrders = orders[tableId];
            let billContent = `
            <h1>Bill for ${tableName} - ${tableId}</h1>
            <table>
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                </thead>
            `;
            let totalAmount = 0;
            for (const itemId in tableOrders) {
                const order = tableOrders[itemId];
                const itemTotal = order.price * order.quantity;
                totalAmount += itemTotal;
                billContent += `
            <tbody>
                <tr>
                    <td>${order.name}</td>
                    <td>${order.price.toFixed(2)}</td>
                    <td>${order.quantity}</td>
                    <td>${itemTotal.toFixed(2)}</td>
                </tr>
            </tbody>
            `;
            }
            billContent += `
                <tfoot>
                    <tr>
                        <td colspan="3"><strong>Total Amount</strong></td>
                        <td><strong>Rs. ${totalAmount.toFixed(2)}</strong></td>
                    </tr>
                </tfoot>
            </table>
            `;

            const printFrame = document.getElementById('printFrame');
            const frameDoc = printFrame.contentWindow.document;
            frameDoc.open();
            frameDoc.write(`
            <html>
            <head>
                <title>Bill</title>
                <style>
                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }
                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: left;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                    .order-total {
                        text-align: right;
                        font-weight: bold;
                        margin-top: 20px;
                    }
                </style>
            </head>
            <body>${billContent}</body>
            </html>
            `);
            frameDoc.close();
            printFrame.contentWindow.focus();
            printFrame.contentWindow.print();
            alert("Order Successful!! More to go..")
            delete orders[tableId];
            renderTables(tables);
            orderModal.style.display = 'none';
        }
    };


    // Filter tables by name
    tableSearchInput.addEventListener('input', event => {
        if (tableSearchInput.value.length == 0) {
            tableSearch.style.display = "block";
            clearTableSearch.style.display = "none";
        }
        else {
            tableSearch.style.display = "none";
            clearTableSearch.style.display = "block";
        }
        const searchQuery = event.target.value.toLowerCase().replace(/\s+/g, '');
        const filteredTables = tables.filter(table => table.name.toLowerCase().includes(searchQuery) || table.id === Number(searchQuery) || (table.name.toLowerCase() + '-' + table.id).includes(searchQuery));
        renderTables(filteredTables);
    });

    // Filter menu items by name or type
    menuSearchInput.addEventListener('input', event => {
        if (menuSearchInput.value.length == 0) {
            menuSearch.style.display = "block";
            clearMenuSearch.style.display = "none";
        }
        else {
            menuSearch.style.display = "none";
            clearMenuSearch.style.display = "block";
        }
        const searchQuery = event.target.value.toLowerCase();
        const filteredMenuItems = menuItems.filter(item =>
            item.name.toLowerCase().includes(searchQuery) ||
            item.type.toLowerCase().includes(searchQuery)
        );
        renderMenuItems(filteredMenuItems);
    });

    // Clear Table Search
    clearTableSearch.addEventListener('click', () => {
        tableSearchInput.value = "";
        clearTableSearch.style.display = "none";
        tableSearch.style.display = "block";
        renderTables(tables);
    });

    // Clear Menu Search
    clearMenuSearch.addEventListener('click', () => {
        menuSearchInput.value = "";
        clearMenuSearch.style.display = "none";
        menuSearch.style.display = "block";
        renderMenuItems(menuItems);
    });

    addTableButton.onclick = () => {
        tableAddModel.style.display = 'block';
    };
    closeTableAddModel.onclick = () => {
        tableAddModel.style.display = 'none';
    };
    addTableForm.onsubmit = event => {
        event.preventDefault();
        const tableName = document.getElementById('tableName').value;
        const tableNumber = parseInt(document.getElementById('tableNumber').value);
        tables.push({ id: tableNumber, name: tableName });
        renderTables(tables);
        addTableForm.reset();
        tableAddModel.style.display = 'none';
    }
});
