 $(document).ready(function(){
            // hide error section
            $("#specCodeError").hide();
            $("#specNameError").hide();
            $("#specNoteError").hide();
           

            var specCodeError = false;
            var specNameError = false;
            var specNoteError = false;

            // define error variable

            function validate_specCode()
            {
                var val1 = $("#specCode").val();
                if (val1=='')
                {
                    $("#specCodeError").show();
                    specCodeError = false;
                    $("#specCodeError").html("code cannot be empty")
                    $("#specCodeError").css('color','red');
                }
                else
                {
                    $("#specCodeError").hide();
                    specCodeError=true;
                }
                return specCodeError;
            }


            function validate_specName()
            {
                var val2 = $("#specName").val();
                if (val2=='')
                {
                    $("#specNameError").show();
                    specNameError = false;
                    $("#specNameError").html("Name cannot be empty")
                    $("#specNameError").css('color','red');
                }
                else
                {
                    $("#specNameError").hide();
                    specNameError=true;
                }
                return specNameError;
            }


            function validate_specNote()
            {
                var val3 = $("#specNote").val();
                if (val3=='')
                {
                    $("#specNoteError").show();
                    specNoteError = false;
                    $("#specNoteError").html("Note cannot be empty")
                    $("#specNoteError").css('color','red');
                }
                else
                {
                    $("#specNoteError").hide();
                    specNoteError=true;
                }
                return specNoteError;
            }

            // action event

            $("#specCode").keyup(function(){
                validate_specCode();
                $(this).val($(this).val().toUpperCase());
            })

            $("#specName").keyup(function(){
                validate_specName();
               
            })

            
            $("#specNote").keyup(function(){
                validate_specNote();
               
            })

            $("#specForm").submit(function(){
                validate_specCode();
                validate_specName();
                validate_specNote();

                
                if ( specCodeError && specNoteError && specNameError ) return true;
                else return false;

            })

        });