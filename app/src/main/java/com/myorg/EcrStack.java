package com.myorg;

import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecr.Repository;
import software.amazon.awscdk.services.ecr.RepositoryProps;
import software.constructs.Construct;

public class EcrStack extends Stack {

  private final Repository productsServiceRepository;

  public EcrStack(final Construct scope, final String id, final StackProps props) {
    super(scope, id, props);

    this.productsServiceRepository = new Repository(this, "ProductsService", RepositoryProps.builder()
        .repositoryName("productsservice")  // Fixed typo: repostioryName -> repositoryName
        .removalPolicy(RemovalPolicy.DESTROY)
        .emptyOnDelete(true)  // Fixed: autoDeleteImages is deprecated, use emptyOnDelete
        .build());
  }

  public Repository getProductsServiceRepository() {
    return productsServiceRepository;
  }
}