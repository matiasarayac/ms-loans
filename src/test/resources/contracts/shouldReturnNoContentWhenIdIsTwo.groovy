import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return no content when Id is equal to 2"
	request{
		method GET()
		url("loans/getLoan/") {
			queryParameters {
				parameter("id", "2")
			}
		}
	}
	response {		
		status 204
	}
}