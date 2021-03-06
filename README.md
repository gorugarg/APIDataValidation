This mule project basically loads the API validation rules from Database and based on the requirement ,stores it in the Hashmap or ObjectStore.
Whenever any rules change , we need to update the DB and refresh the corresponding interface.

Types of Validation Rules -
1) Whether a field is mandatory or not.
2) Whether a field has the required min length.
3) Whether a field has the required max length.
4) Whether a field follows the proper enumeration.
5) Whether a field follows the proper regex pattern.

Below is the sample of validation rules. Element path is required in validation rule because the incoming request will be validated against it and corresponding rules will be applied on it. Every API will have its own validation rule. 

{"DataElement": [
      {
        "ElementPath": "employee.employeeDetails.employeeNumber",
        "MinLength": "1",
        "MaxLength": "50",
        "Enum": "2,5,7,9,11",
        "Mandatory":true
      },
      {
        "ElementPath": "employee.employeeDetails.employeeName",
        "MinLength": "2",
        "MaxLength": "255",
        "Pattern": "([a-z]*).[a-z]*"
      }
    ]}' 
	

Sample Input Request - 

{
	"employee": {
		"employeeDetails": {
			"employeeNumber": 3,
			"employeeName": "Gaurav.com.com"

		}
	}
}

Sample Response  -

{
    "message": "Validation fails at field level",
    "failureFields": [
        {
            "elementPath": "employee.employeeDetails.employeeNumber",
            "validationResult": "Fail",
            "flag": "enum"
        },
        {
            "elementPath": "employee.employeeDetails.employeeName",
            "validationResult": "Fail",
            "flag": "pattern"
        }
    ]
}





