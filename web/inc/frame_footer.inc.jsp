<%--
  Created by IntelliJ IDEA.
  User: 38403
  Date: 2019/12/9
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="hidePane">
    <div id="tip" class="invisible">
        <i class="fa fa-check"></i>
        <span class="tip-content"></span>
    </div>
    <div id="error" class="invisible">
        <i class="fa fa-close"></i>
        <span class="error-content"></span>
    </div>
    <button class="btn btn-primary btn-lg hide" data-toggle="modal" data-target="#messageModal" id="btn-message-modal" style="display: none"></button>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="messageModalLabel">
                    详细错误信息
                </h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body" id="message-modal-content" style="white-space: pre-line;">
                在这里添加一些文本
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- Sticky Footer -->
<footer class="sticky-footer">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span>Produced and maintained by DengPeng and YuJitao in December,2019.</span>
        </div>
    </div>
</footer>