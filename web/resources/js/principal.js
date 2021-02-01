/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.loggedIn) {
        jQuery('#dialog').effect("shake", {
            times: 3
        }, 100);
    } else {
        dlg.hide();
    }
}
function handleMessages(xhr, status, args) {
    if (args.isValid) {
        errorWidget.show();
    } else {
        errorWidget.hide();
    }
}

function open_win2(archivo, titulo) {
    window.open(archivo, titulo, 'dependent=yes, menubar=no, toolbar=no,location=no');
    return false;
}

function open_win(archivo,titulo){
    window.open(archivo, "_blank", 'height=800,width=1024,top=10, dependent=yes, menubar=no, toolbar=no,location=no');
}

function selectOne(form, button) {
    turnOffRadioForForm(form);
    button.checked = true;
}
function turnOffRadioForForm(form) {
    for (var i = 0; i < form.elements.length; i++) {
        form.elements[i].checked = false;
    }
}


function radiobuttonClick(thisObj) {
    var form = document.getElementById("formTabla");
    for (var i = 0; i < form.elements.length; i++) {
        form.elements[i].checked = false;
//        getRow(form.elements[i]).className = "ui-datatable-data ui-widget-content";
    }
    thisObj.checked = true;                       //set this radio button to selected state
//    getRow(thisObj).className = "ui-widget-content ui-state-highlight"; //highlight the selected row
}

function getRow(element) {
    currentRow = element.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
    return currentRow;
}