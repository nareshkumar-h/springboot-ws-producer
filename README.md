# springboot-ws-producer

#### Input XML
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://revature.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getLoginRequest>
         <gs:email>naresh@gmail.com</gs:email>
         <gs:password>pass123</gs:password>
      </gs:getLoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### Response: Valid
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getLoginResponse xmlns:ns2="http://revature.com/webservice">
            <ns2:user>
                <ns2:id>1</ns2:id>
                <ns2:name>naresh</ns2:name>
                <ns2:email>naresh@gmail.com</ns2:email>
                <ns2:password>pass123</ns2:password>
            </ns2:user>
        </ns2:getLoginResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```


#### Response: Error Message
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <SOAP-ENV:Fault>
            <faultcode>SOAP-ENV:Server</faultcode>
            <faultstring xml:lang="en">Invalid Login</faultstring>
        </SOAP-ENV:Fault>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

