
<div class="container">
   <div id="commentsTable" class="row">
      <div class="col-sm-9">
         <h4>Loyalty One: Hello World</h4>
         <hr>
         <form id="commentForm" role="form">
            <div class="form-group">
               <label for="comment">Comment:</label>
               <textarea class="form-control" required rows="2" id="comment"></textarea>
            </div>
            <br/>
            <button type="submit" class="btn btn-default">Done</button>
         </form>
      </div>
      <div class="col-sm-9" id="displayComment"></div>
   </div>

   
   <!-- Modal -->
   <div id="replyFormModal" class="modal fade" role="dialog">
     <div class="modal-dialog">
       <!-- Modal content-->
       <div class="modal-content">
         <form id="replyForm" role="form">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal">&times;</button>
           <h4 class="modal-title">Modal Header</h4>
         </div>
         <div class="modal-body">
            <div class="form-group">
               <label for="replyComment">Reply Comment:</label>
               <textarea class="form-control" required rows="2" id="replyComment" name="comment"></textarea>
               <input id="replyCommentId" type="hidden" name="parentId"></input>
               <input id="replyNesting" type="hidden" name="nesting"></input>
            </div>
            <br/>

         </div>
         <div class="modal-footer">
            <button type="submit" class="btn btn-default">Done</button>
         </div> 
         </form>
      </div>
     </div>
   </div>

</div>

