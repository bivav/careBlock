pragma solidity ^0.5.0;

contract Records{

	struct Patient{
		uint pid;
		uint did;
		string name;
		string patient_summary;
		bytes32 sha_password;

	}
	mapping(uint => Patient)public Patients;
	uint public Patient_count;

	constructor(string memory _name,bytes memory _key,uint did) public {
		addPatient(_name,_key,did);
	}

	function addPatient(string memory _name,bytes memory _key,uint did)private{
		Patient_count++;
		Patients[Patient_count]=Patient(Patient_count,did,_name,"",sha256(_key));
	}

	function addRecord(uint pid,string memory _record,bytes32 _sha_password)public{

		for(uint i=1;i<=Patient_count;i++){
			if(i==pid)
				if(Patients[i].sha_password==_sha_password)
					Patients[i].patient_summary = _record;
		}
	
	}
	function getRecord(uint pid)public returns(string memory){
		for(uint i=1;i<=Patient_count;i++){
			if(i==pid)
				if(Patients[i].pid==pid)
					return Patients[i].patient_summary;
	}
	}

}
