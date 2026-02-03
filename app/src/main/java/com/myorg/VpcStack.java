package com.myorg;


public class VpcStack extends Stack {

  private final Vpc vpc;

  public VpcStack(final Construct scope, final String id, final StackProps props) {
    super(scope, id, props);

    this.vpc = new Vpc(this, "Vpc", VpcProps.builder()
        .vpcName("EcommerceVPC")
        .maxAzs(2)
        .natGateways(0)
        .build());
  }


  public Vpc getVpc() {
    return vps;
  }

}