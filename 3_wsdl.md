#### Types
```
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
	
	<xs:element name="getLoginResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="user" type="tns:user"/>
			</xs:sequence>
		</xs:complexType>	
		
	</xs:element>
	<xs:complexType name="user">
			<xs:sequence>
				<xs:element name="id" type="xs:int"/>
				<xs:element name="name" type="xs:string"/>
				<xs:element name="email" type="xs:string"/>
				<xs:element name="password" type="xs:string"/>
			</xs:sequence>
	</xs:complexType>
</xs:schema>
  </wsdl:types>
  ```
####  Port Type
```
  <wsdl:message name="getLoginResponse">
    <wsdl:part element="tns:getLoginResponse" name="getLoginResponse">
    </wsdl:part>
  </wsdl:message>
  <wsdl:message name="getLoginRequest">
    <wsdl:part element="tns:getLoginRequest" name="getLoginRequest">
    </wsdl:part>
  </wsdl:message>
  <wsdl:portType name="UsersPort">
    <wsdl:operation name="getLogin">
      <wsdl:input message="tns:getLoginRequest" name="getLoginRequest">
    </wsdl:input>
      <wsdl:output message="tns:getLoginResponse" name="getLoginResponse">
    </wsdl:output>
    </wsdl:operation>
  </wsdl:portType>
  ```
#### Binding
```
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
```

#### Service
```
  <wsdl:service name="UsersPortService">
    <wsdl:port binding="tns:UsersPortSoap11" name="UsersPortSoap11">
      <soap:address location="http://localhost:8090/ws"/>
    </wsdl:port>
  </wsdl:service>
  ```
