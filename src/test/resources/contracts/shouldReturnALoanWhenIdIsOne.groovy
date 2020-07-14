import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a loan when the Id is equal to 1"
    request{
        method GET()
        url("/loans/getLoan/") {
            queryParameters {
                parameter("id", "1")
            }
        }
    }
    response {
        body(id: 1, type: "hipotecario", debtAmount:1000)
        status 200
    }
}