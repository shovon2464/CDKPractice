package com.myorg;

public class NlbStack extends Stack {

  private final VpcLink vpcLink;
  private final NetworkLoadBalancer networkLoadBalancer;
  private final ApplicationLoadBalancer applicationLoadBalancer;

  public NlbStack(final Construct scope, final String id,
      final StackProps props, NlbStackProps nlbStackProps) {
    super(scope, id, props);


    this.networkLoadBalancer = new NetworkLoadBalancer(this, "Nlb",
        NetworkLoadBalancerProps.builder()
            .loadBalancerName("ECommerceNlb")
            .internetFacing(false)
            .vpc(nlbStackProps.vpc())
            .build());

    this.vpcLink = new VpcLink(this, "VpcLink",
        VpcLinkProps.builder()
            .targets(Collections.singletonList(this.networkLoadBalancer))
            .build());

    this.applicationLoadBalancer = new ApplicationLoadBalancer(this, "Alb",
        ApplicationLoadBalancerProps.builder()
            .loadBalancerName("ECommerceAlb")
            .internetFacing(false)
            .vpc(nlbStackProps.vpc())
            .build());



  }




  public VpcLink getVpcLink() {
    return vpcLink;
  }

  public NetworkLoadBalancer getNetworkLoadBalancer() {
    return networkLoadBalancer;
  }

  public ApplicationLoadBalancer getApplicationLoadBalancer() {
    return applicationLoadBalancer;
  }

}

record NlbStackProps(
    Vpc vpc
){}
