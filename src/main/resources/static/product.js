$(document).ready(function () {
    getProducts();
});

let prId = null;
function getProducts() {
    let body = $("#products").html('');
    $.ajax({
        url: 'http://localhost:8081/products/findProductAll',
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            for (let i = 0; i < resp.length; i++) {
                body += ' <tr id="row-' + resp[i].productId + '">\n' +
                    '                        <td>' + resp[i].productName + '</td>\n' +
                    '                        <td>' + resp[i].productPrice + '</td>\n' +
                    '                        <td>\n' +
                    '                            <button onclick="deleteRow(' + resp[i].productId + ')" class="btn btn-danger btn-xs">X</button>\n' +
                    '                            <button onclick="upProduct(' + resp[i].productId + ')" class="btn btn-success btn-xs">Edit</button>\n' +
                    '                        </td>\n' +
                    '                    </tr>';

            }
            console.log(body);
            $("#products").html(body);

        }
    });
}

function upProduct(productId) {
    $("#updateModal").modal('show');

    $.ajax({
        url: 'http://localhost:8081/products/findProductById?idc=' + productId ,
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            prId = productId;
            $("#mtProductName").html(resp.productName);
            $("#mProductName").val(resp.productName);
            $("#mProductPrice").val(resp.productPrice);
            $("#mBarcode").val(resp.barcode);
        }
    });


}
function deleteRow(productId) {
    $.ajax({
        url: 'http://localhost:8081/products/deleteProduct?idPro='+ productId,
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            window.location.reload();

        }
    });
}

function saveU(){
    let productName = $("#mProductName").val();
    let productPrice = $("#mProductPrice").val();
    let productBarcode = $("#mBarcode").val();
    $.ajax({
        url: 'http://localhost:8081/products/addProduct',
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'POST',
        data: JSON.stringify({
            productId: prId,
            productName: productName,
            productPrice: productPrice,
            barcode: productBarcode
        }),
        dataType: 'JSON',
        success: function (resp) {
            getProducts();
            $("#updateModal").modal('toggle');
        }
    });
}

function addProduct() {
    let data = {
        productName: $("#productName").val(),
        productPrice: $("#productPrice").val(),
        barcode: $("#barcode").val()
    };
    console.log(data);
    $.ajax({
        url: 'http://localhost:8081/products/addProduct',
        headers: {
            'Content-Type': 'application/json' ,
            'Accept' : 'application/json'
        },
        data: JSON.stringify(data),
        type: 'POST',
        dataType: 'JSON',
        success: function (resp) {
            window.location.reload();
        }
    });
}