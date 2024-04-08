#Spring Data JPA Basic Concepts

The java persistence API provides a specification for persisting, reading, and managing data from your java object to your relational tables in the database. 
JPA specifies the set of rules and guidelines for developing interfaces that follow standards.
Spring Data JPA is part of the spring framework. 
The goal of spring data repository abstraction is to significantly reduce the amount of boilerplate code required to implement a data access layer for various persistence stores. 
Spring Data JPA is not a JPA provider, it is a library/framework that adds an extra layer of abstraction on the top of our JPA provider line Hibernate.
ORM (Object relation mapping) is simply the process of persisting any java object directly into a database table.


We have used some of the below JPA & Hibernate annotations in our code.

	JPA Annotations for mapping java object to database table
	• @Entity: Specifies that the class is an entity. This annotation can be applied on Class, Interface of Enums.
	• @Table: It specifies the table in the database with which this entity is mapped.
	• @Column: Specify the column mapping using @Column annotation.
	• @Id: This annotation specifies the primary key of the entity.
	• @GeneratedValue: This annotation specifies the generation strategies for the values of primary keys.

 	• @Query: @Query annotation, it provides us with the opportunity to write a specific JPQL or SQL query in the @Query annotation:
	• @Modifying: for updating queries, we must add the @Modifying annotation. The @Modfying annotation is used to enhance the @Query annotation so that we can execute not only SELECT queries, but also INSERT, UPDATE, DELETE, and even DDL queries.

Hibernate Annotations for Mapping between tables
	@OneToOne: For one to one mapping
	@PrimaryKeyJoinColumn should be used for associated entities sharing the same primary key.
  @JoinColumn & @OneToOne should be mappedBy attribute when foreign key is held by one of the entities.

  @OneToMany
	@JoinColumn annotation is used for one-to-one or many-to-one associations when foreign key is held by one of the entities.
	@JoinTable: @JoinTable and mappedBy should be used for entities linked through an association table. 
  @MapsId: Two entities with shared key can be persisted using @MapsId annotation.


  Cascading: Entity relationships often depend on the existence of another entity. 
	When we perform some action on the target entity, the same action will be applied to the associated entity.
 
  • CascadeType.ALL
  CascadeType.ALL propagates all operations — including Hibernate-specific ones — from a parent to a child entity.
  
  • CascadeType.PERSIST
	Cascade Type PERSIST propagates the persist operation from a parent to a child entity. When we save the person entity, the address entity will also get saved.
	
  • CascadeType.MERGE
	The merge operation copies the state of the given object onto the persistent object with the same identifier. CascadeType.MERGE propagates the merge operation from a parent to a child entity.
	
	• CascadeType.REMOVE
	As the name suggests, the remove operation removes the row corresponding to the entity from the database and also from the persistent context.
  CascadeType.REMOVE propagates the remove operation from parent to child entity. Similar to JPA’s CascadeType.REMOVE, we have CascadeType.DELETE, which is specific to Hibernate.

