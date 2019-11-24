
$('#sub').click(function () {
                    $.ajax({
                        // 提交的地址
                        url:'addContact',
                        // 提交的方式
                        type:'post',
                        // 提交的数据
                        data:{'username': username,'phone': phone, 'massage': massage},
                        // 回调函数
                        success:function (data) {  // data接收的就是异步提交返回的结果
                            alert(data)
                        }
                    })
                })