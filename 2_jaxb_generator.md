
#### Schema Generator - Generate Classes based on XSD
* user.xsd
```
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:tns="http://revature.com/webservice"
	targetNamespace="http://revature.com/webservice"
	elementFormDefault="qualified">

	<xs:element name="user">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="id" type="xs:int"/>
				<xs:element name="name" type="xs:string" />
				<xs:element name="email" type="xs:string" />
				<xs:element name="password" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

</xs:schema>
```

#### Generate JAXB classes from XSD 
![](jaxb.png)


#### Add Plugin in pom.xml
```
<build>
		<plugins>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<id>xjc</id>
						<goals>
							<goal>xjc</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<schemaDirectory>${project.basedir}/src/main/resources/</schemaDirectory>
					<outputDirectory>${project.basedir}/src/main/java</outputDirectory>
					<clearOutputDir>false</clearOutputDir>
				</configuration>
			</plugin>
		</plugins>
	</build>
  ```

