$(document).ready(function () {
    getProducts();
});


function getProducts() {
    let body = $("#orders").html('');
    $.ajax({
        url: 'http://localhost:8081/orders/findAllOrder',
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            for (let i = 0; i < resp.length; i++) {
                body += ' <tr id="row-' + resp[i].orderId + '">\n' +
                    '                        <td>' + resp[i].orderId + '</td>\n' +
                    '                        <td>' + resp[i].total + '</td>\n' +
                    '                        <td>\n' +
                    '                            <button onclick="getSales(' + resp[i].orderId + ')" class="btn btn-success btn-xs">View Action</button>\n' +
                    '                        </td>\n' +
                    '                    </tr>';

            }
            console.log(body);
            $("#orders").html(body);
        }
    });
}

function getSales(orderId) {
    let body = $("#products").html('');
    $.ajax({
        url: 'http://localhost:8081/sales/findByOrder?ordereId='+ orderId,
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            for (let i = 0; i < resp.length; i++) {
                body += ' <tr id="row-' + resp[i].productEntity.productId + '">\n' +
                    '                        <td>' + resp[i].productEntity.productName + '</td>\n' +
                    '                        <td>' + resp[i].productEntity.productPrice + '</td>\n' +
                    '                    </tr>';

            }
            console.log(body);
            $("#products").html(body);
        }
    });
}

