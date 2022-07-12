<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <img style="display: inline;" src="img/maveric-logo-updated.png" alt="logo" />
            <span class="lead">Maveric bank </span>
        </div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="firstName">First Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.firstName" id="firstName" class="first-name form-control input-sm" placeholder="Enter your First Name" required ng-minlength="5"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="lastName">Last Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.lastName" id="lastName" class="form-control input-sm" placeholder="Enter your Last Name." required ng-minlength="5"/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="email">Email</label>
	                        <div class="col-md-7">
	                            <input type="email" ng-model="ctrl.user.email" id="email" class="form-control input-sm" placeholder="Enter your email." required/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phoneNumber">Phone</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.user.phoneNumber" id="phoneNumber" class="form-control input-sm" placeholder="Enter your phone No." required pattern="[0-9]{10}"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="gender">Gender</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.gender" id="gender" class="form-control input-sm" placeholder="Enter your Gender." required list="genderList"/>
                                <datalist id="genderList">
                                  <option value="Male">
                                  <option value="Female">
                                </datalist>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="dob">dob</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.dob" id="dob" value="2018-07-22"  class="form-control input-sm" placeholder="dd-mm-yyyy" required/>
                            </div>
                        </div>
                    </div>

	                <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="password">Password</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.password" id="password" class="form-control input-sm" placeholder="Enter your Password." required  ng-minlength="5" ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>


	                <div class="row">
	                    <div class="form-actions floatRight buttons-row">
	                        <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>
		<div class="panel-heading" style="background-color:#6285d9;">
		    <img style="display: inline;" src="img/maveric-logo-updated.png" alt="logo" />
            <span class="lead" style="color:white;font-size:10px" >Copyright @2022 Maveric Syatems India Pvt Ltd. </span>
		</div>
    </div>
</div>