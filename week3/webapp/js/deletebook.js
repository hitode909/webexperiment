function XMLRequest(){
    if(this.XMLHttpRequest){ 
        return new XMLHttpRequest();
    }else {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}
    
function deleteBook(id){
    if (!id) return;
    if (!confirm("本当に削除しますか？")) {
        return;
    }

    var obj=XMLRequest();
    obj.onreadystatechange = function(){
        if (obj.readyState == 4 && obj.status == 200){
            req=obj.responseText.replace("\n","");
            if (req == "deleted") {
                alert('削除されした．');
                location.replace('./');
            }else{
                alert('エラー:'+req);
            }
        }
    }
    var URL='book.delete.jsp';
    obj.open("POST",URL,true);
    obj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    obj.send('bookid='+id);
}