# springboot-ws-producer

#### WSDL file
```
<wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:sch="http://revature.com/webservice" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://revature.com/webservice" targetNamespace="http://revature.com/webservice">
<wsdl:types>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="http://revature.com/webservice">
<xs:element name="getLoginRequest">
<xs:complexType>
<xs:sequence>
<xs:element name="email" type="xs:string"/>
<xs:element name="password" type="xs:string"/>
</xs:sequence>
</xs:complexType>
</xs:element>
<xs:element name="getLoginResponse">...</xs:element>
<xs:complexType name="user">...</xs:complexType>
</xs:schema>
</wsdl:types>
<wsdl:message name="getLoginResponse">
<wsdl:part element="tns:getLoginResponse" name="getLoginResponse"> </wsdl:part>
</wsdl:message>
<wsdl:message name="getLoginRequest">
<wsdl:part element="tns:getLoginRequest" name="getLoginRequest"> </wsdl:part>
</wsdl:message>
<wsdl:portType name="UsersPort">
<wsdl:operation name="getLogin">
<wsdl:input message="tns:getLoginRequest" name="getLoginRequest"> </wsdl:input>
<wsdl:output message="tns:getLoginResponse" name="getLoginResponse"> </wsdl:output>
</wsdl:operation>
</wsdl:portType>
<wsdl:binding name="UsersPortSoap11" type="tns:UsersPort">
<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
<wsdl:operation name="getLogin">
<soap:operation soapAction=""/>
<wsdl:input name="getLoginRequest">
<soap:body use="literal"/>
</wsdl:input>
<wsdl:output name="getLoginResponse">
<soap:body use="literal"/>
</wsdl:output>
</wsdl:operation>
</wsdl:binding>
<wsdl:service name="UsersPortService">
<wsdl:port binding="tns:UsersPortSoap11" name="UsersPortSoap11">
<soap:address location="http://localhost:8090/ws"/>
</wsdl:port>
</wsdl:service>
</wsdl:definitions>
```


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

