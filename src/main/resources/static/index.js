
let barcode = document.getElementById("barcode");
barcode.addEventListener("keydown", function (e) {
    if (e.code === "Enter") {  //checks whether the pressed key is "Enter"
        getProduct(e);
    }
});


let items = [];
let total = 0.0;

// const barcode = e.target.value;
function getProduct(e) {
    let body = $("#items").html();
    const barcode = e.target.value;
    $.ajax({
        url: 'http://localhost:8081/products/findProductByBarcode?Barcode=' + barcode,
        type: 'GET',
        dataType: 'JSON',
        success: function (resp) {
            console.log(resp);
            body += ' <tr id="row-' + resp.productId + '">\n' +
                '                        <td>' + resp.productName + '</td>\n' +
                '                        <td>' + resp.productPrice + '</td>\n' +
                '                        <td>\n' +
                '                            <button onclick="deleteRow(' + resp.productId + ',' + resp.productPrice + ')" class="btn btn-danger btn-xs">X</button>\n' +
                '                        </td>\n' +
                '                    </tr>';
            $("#items").html(body);

            items.push({
                productId: resp.productId,
                productPrice: resp.productPrice
            });

            total += resp.productPrice;
            $("#total").html(total);
            console.log(items);
            JSON.stringify(items);
        }
    });
}


function deleteRow(rowId, productPrice) {
    $("#row-" + rowId).remove();
    total -= productPrice;
    $("#total").html(total);
    items = $.grep(items, function(e){
        return e.productId != rowId;
    });
    console.log(items);
}

function saveOrder() {
    console.log("yees");
    $.ajax({
        url: 'http://localhost:8081/orders/saveOrder',
        headers: {
            'Content-Type': 'application/json'
        },
        type: 'POST',
        data: JSON.stringify(items),
        dataType: 'JSON',
        success: function (resp) {
            console.log(resp);
            alert("Successfully saved Order NO : " + resp.orderId);
            window.location.reload();
        }
    });
}



