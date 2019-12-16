package stc21.smartmediator.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.repository.*;

import java.math.BigDecimal;
import java.util.*;

@Component
public class TestDataGenerator {

    @Autowired
    private final OrgStatusesRepository orgStatusesRepository;

    @Autowired
    private final OrganizationsRepository organizationsRepository;

    @Autowired
    private final SellersRepository sellersRepository;

    @Autowired
    private final RolesRepository rolesRepository;

    @Autowired
    private final OrderStatusesRepository orderStatusesRepository;

    @Autowired
    private final DeliveryTypesRepository deliveryTypesRepository;

    @Autowired
    private final UserStatusesRepository userStatusesRepository;

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final UsersOrganizationsRepository usersOrganizationsRepository;

    @Autowired
    private final PricePatternsRepository pricePatternsRepository;

    @Autowired
    private final BuyersRepository buyersRepository;

    @Autowired
    private final LogisticsPointsRepository logisticsPointsRepository;

    @Autowired
    private final ProductsTypesRepository productsTypesRepository;

    @Autowired
    private final UnitsRepository unitsRepository;

    @Autowired
    private final ProductsRepository productsRepository;

    @Autowired
    private final OrdersRepository ordersRepository;

    @Autowired
    private final TraceOrdersRepository traceOrdersRepository;

    @Autowired
    private final OrdersProductsRepository ordersProductsRepository;

    @Autowired
    private final PricesRepository pricesRepository;

    @Autowired
    private final ExternalLinksRepository externalLinksRepository;

    @Autowired
    private UsersRolesRepository usersRolesRepository;

    public TestDataGenerator(OrgStatusesRepository orgStatusesRepository, OrganizationsRepository organizationsRepository, SellersRepository sellersRepository, RolesRepository rolesRepository, OrderStatusesRepository orderStatusesRepository, DeliveryTypesRepository deliveryTypesRepository, UserStatusesRepository userStatusesRepository, UsersRepository usersRepository, UsersOrganizationsRepository usersOrganizationsRepository, PricePatternsRepository pricePatternsRepository, BuyersRepository buyersRepository, LogisticsPointsRepository logisticsPointsRepository, ProductsTypesRepository productsTypesRepository, UnitsRepository unitsRepository, ProductsRepository productsRepository, OrdersRepository ordersRepository, TraceOrdersRepository traceOrdersRepository, OrdersProductsRepository ordersProductsRepository, PricesRepository pricesRepository, ExternalLinksRepository externalLinksRepository, UsersRolesRepository usersRolesRepository) {
        this.orgStatusesRepository = orgStatusesRepository;
        this.organizationsRepository = organizationsRepository;
        this.sellersRepository = sellersRepository;
        this.rolesRepository = rolesRepository;
        this.orderStatusesRepository = orderStatusesRepository;
        this.deliveryTypesRepository = deliveryTypesRepository;
        this.userStatusesRepository = userStatusesRepository;
        this.usersRepository = usersRepository;
        this.usersOrganizationsRepository = usersOrganizationsRepository;
        this.pricePatternsRepository = pricePatternsRepository;
        this.buyersRepository = buyersRepository;
        this.logisticsPointsRepository = logisticsPointsRepository;
        this.productsTypesRepository = productsTypesRepository;
        this.unitsRepository = unitsRepository;
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
        this.traceOrdersRepository = traceOrdersRepository;
        this.ordersProductsRepository = ordersProductsRepository;
        this.pricesRepository = pricesRepository;
        this.externalLinksRepository = externalLinksRepository;
        this.usersRolesRepository = usersRolesRepository;
    }

    private ArrayList<OrganizationsEntity> getOrgs(List<OrgStatusesEntity> statuses, int count, int i) {
        ArrayList<OrganizationsEntity> orgs = new ArrayList<>();
        for (OrgStatusesEntity status : Collections.unmodifiableList(statuses)) {
            for (int j = 0; j < count; j++) {
                OrganizationsEntity organization = new OrganizationsEntity(
                        "Full name " + i, "name " + i, "inn " + i, "address" + i, status.getId());
                orgs.add(organization);
                i++;
            }
        }
        return orgs;
    }

    public void deleteData() {

        System.out.println("Data will be deleted.");

        externalLinksRepository.deleteAll();
        pricesRepository.deleteAll();
        ordersProductsRepository.deleteAll();
        traceOrdersRepository.deleteAll();
        ordersRepository.deleteAll();
        logisticsPointsRepository.deleteAll();
        productsRepository.deleteAll();
        buyersRepository.deleteAll();
        pricePatternsRepository.deleteAll();
        sellersRepository.deleteAll();
        usersOrganizationsRepository.deleteAll();
        organizationsRepository.deleteAll();
        usersRepository.deleteAll();
        orgStatusesRepository.deleteAll();
        userStatusesRepository.deleteAll();
        rolesRepository.deleteAll();
        orderStatusesRepository.deleteAll();
        deliveryTypesRepository.deleteAll();
        unitsRepository.deleteAll();
        productsTypesRepository.deleteAll();
        usersRolesRepository.deleteAll();
    }

    public void createData(int multiplier) {

        System.out.println("Generate test data start.");

        List<OrgStatusesEntity> statuses = new ArrayList<>();
        statuses.add(new OrgStatusesEntity("new", "Новая"));
        statuses.add(new OrgStatusesEntity("wait", "Ожидает"));
        statuses.add(new OrgStatusesEntity("confirm", "Подтверждена"));
        statuses.add(new OrgStatusesEntity("ban", "Забанена"));
        orgStatusesRepository.saveAll(statuses);

        System.out.println("Add OrgStatusesEntity: " + statuses.size());

        List<UserStatusesEntity> userStatuses = new ArrayList<>();
        userStatuses.add(new UserStatusesEntity("new", "Новая"));
        userStatuses.add(new UserStatusesEntity("wait", "Ожидает"));
        userStatuses.add(new UserStatusesEntity("confirm", "Подтверждена"));
        userStatuses.add(new UserStatusesEntity("ban", "Забанена"));
        userStatusesRepository.saveAll(userStatuses);

        System.out.println("Add UserStatusesEntity: " + userStatuses.size());

        RolesEntity r = new RolesEntity("user", "Пользователь");
        rolesRepository.save(r);
        r = new RolesEntity("admin", "Администратор");
        rolesRepository.save(r);

        System.out.println("Add RolesEntity: 2");

        List<OrderStatusesEntity> orderStatuses = new ArrayList<>();
        orderStatuses.add(new OrderStatusesEntity("draft", "Черновик"));
        orderStatuses.add(new OrderStatusesEntity("new", "Новый"));
        orderStatuses.add(new OrderStatusesEntity("cancel", "Отменен"));
        orderStatuses.add(new OrderStatusesEntity("taken", "Подтвержден"));
        orderStatuses.add(new OrderStatusesEntity("shipped", "Отправлен"));
        orderStatuses.add(new OrderStatusesEntity("delivered", "Доставлен"));
        orderStatuses.add(new OrderStatusesEntity("lost", "Потерян"));
        orderStatusesRepository.saveAll(orderStatuses);

        System.out.println("Add OrderStatusesEntity: " + orderStatuses.size());

        DeliveryTypesEntity dt = new DeliveryTypesEntity("pickup", "Самовывоз");
        deliveryTypesRepository.save(dt);
        dt = new DeliveryTypesEntity("supply", "Доставка");
        deliveryTypesRepository.save(dt);

        System.out.println("Add OrderStatusesEntity: 2");

        int i = 0;
        int muliplier = 2;
        int totalOrgCount = statuses.size() * muliplier * 2;

        ArrayList<OrganizationsEntity> sellerOrgs = getOrgs(statuses, muliplier, 0);
        ArrayList<OrganizationsEntity> buyerOrgs = getOrgs(statuses, muliplier, sellerOrgs.size());
        organizationsRepository.saveAll(sellerOrgs);
        organizationsRepository.saveAll(buyerOrgs);

        System.out.println("Add OrderStatusesEntity: " + (sellerOrgs.size() + buyerOrgs.size()));

        i = 0;
        for (OrganizationsEntity org : sellerOrgs) {
            SellersEntity seller = new SellersEntity(org.getId());
            sellersRepository.save(seller);
        }

        System.out.println("Add SellersEntity: " + sellerOrgs.size());

        UUID userRoleId = rolesRepository.findByCode("user").getId();

        List<UsersOrganizationsEntity> usersOrganizations = new ArrayList<>();
        List<OrganizationsEntity> orgs = organizationsRepository.findAll();
        i = 0;
        for (UserStatusesEntity userStatus : userStatuses) {
            for (OrganizationsEntity org : orgs) {
                for (int j = 0; j < muliplier; j++) {

                    UsersEntity usersEntityTemp = new UsersEntity(
                            "email_" + i,
                            "123",
                            "name" + i,
                            userStatus.getId(),
                            true);

                    UsersEntity newUser = usersRepository.save(usersEntityTemp);
                    usersOrganizations.add(new UsersOrganizationsEntity(newUser.getId(), org.getId()));
                    if (i % 4 == 0) {
                        usersRolesRepository.save(new UsersRolesEntity(newUser.getId(), "ADMIN"));
                    } else if (i % 4 == 1) {
                        usersRolesRepository.save(new UsersRolesEntity(newUser.getId(), "USER"));
                    } else if (i % 4 == 2) {
                        usersRolesRepository.save(new UsersRolesEntity(newUser.getId(), "SELLER"));
                    }else {
                        usersRolesRepository.save(new UsersRolesEntity(newUser.getId(), "BUYER"));
                    }
                    i++;
                }
            }
        }

        usersOrganizationsRepository.saveAll(usersOrganizations);
        int totalUsers = userStatuses.size() * orgs.size() * muliplier;
        System.out.println("Add UsersEntity: " + totalUsers);
        System.out.println("Add UsersOrganizationsEntity: " + totalUsers);
        List<SellersEntity> sellers = sellersRepository.findAll();
        i = 0;
        List<PricePatternsEntity> patterns = new ArrayList<>();
        for (SellersEntity seller : sellers) {
            for (int j = 0; j < muliplier; j++) {
                patterns.add(new PricePatternsEntity(
                        "code " + i, "name " + i, null, "note " + i, seller.getId()));
                i++;
            }
        }

        pricePatternsRepository.saveAll(patterns);
        List<PricePatternsEntity> childPatterns = new ArrayList<>();
        for (PricePatternsEntity parent : patterns) {
            for (int j = 0; j < muliplier; j++) {
                childPatterns.add(new PricePatternsEntity(
                        "code " + i, "name " + i, parent.getId(), "note " + i, parent.getSellerId()));
                i++;
            }
        }

        pricePatternsRepository.saveAll(childPatterns);
        System.out.println("Add PricePatternsEntity: " + i);

        i = 0;
        List<BuyersEntity> buyers = new ArrayList<>();
        int buyerCount = Math.min(buyerOrgs.size(), patterns.size());
        Iterator<OrganizationsEntity> orgIterator = buyerOrgs.iterator();
        Iterator<PricePatternsEntity> patternsIterator = patterns.iterator();
        for (int j = 0; j < buyerCount; j++) {
            PricePatternsEntity pattern = patternsIterator.next();
            OrganizationsEntity org = orgIterator.next();
            buyers.add(new BuyersEntity(org.getId(), pattern.getId()));
        }

        buyersRepository.saveAll(buyers);
        System.out.println("Add BuyersEntity: " + buyerCount);

        i = 0;
        List<LogisticsPointsEntity> points = new ArrayList<>();
        for (OrganizationsEntity org : orgs) {
            for (int j = 0; j < muliplier; j++) {
                points.add(new LogisticsPointsEntity(
                        "code " + i, "name " + i, "address " + i, org.getId()));
                i++;
            }
        }
        logisticsPointsRepository.saveAll(points);
        int pointsTotal = totalOrgCount * muliplier;
        System.out.println("Add LogisticsPointsEntity: " + pointsTotal);

        i = 0;
        List<ProductsTypesEntity> productTypes = new ArrayList<>();
        for (int j = 0; j < muliplier; j++) {
            productTypes.add(new ProductsTypesEntity("code " + i, "name " + i));
            i++;
        }
        productsTypesRepository.saveAll(productTypes);
        System.out.println("Add ProductsTypesEntity: " + i);

        i = 0;
        List<UnitsEntity> units = new ArrayList<>();
        for (int j = 0; j < muliplier; j++) {
            units.add(new UnitsEntity("code " + i, "name " + i));
            i++;
        }
        unitsRepository.saveAll(units);
        System.out.println("Add UnitsEntity: " + i);

        i = 0;
        List<ProductsEntity> products = new ArrayList<>();
        Random rnd = new Random();
        for (SellersEntity seller : sellers) {
            for (ProductsTypesEntity productType : productTypes) {
                for (UnitsEntity unit : units) {
                    for (int j = 0; j < muliplier; j++) {
                        products.add(new ProductsEntity(
                                "code " + i,
                                "name " + i,
                                BigDecimal.valueOf(rnd.nextInt(100)),
                                "note " + i,
                                unit.getId(),
                                productType.getId(),
                                seller.getId()));
                        i++;
                    }
                }
            }
        }

        products = productsRepository.saveAll(products);
        int productsCount = sellers.size() * units.size() * productTypes.size() * muliplier;
        System.out.println("Add UnitsEntity: " + productsCount);
        List<DeliveryTypesEntity> deliveryTypes = deliveryTypesRepository.findAll();
        i = 0;
        List<OrdersEntity> orders = new ArrayList<>();
        for (OrderStatusesEntity orderStatus : orderStatuses) {
            for (DeliveryTypesEntity delivery : deliveryTypes) {
                for (SellersEntity seller : sellers) {
                    for (BuyersEntity buyer : buyers) {
                        Collection<LogisticsPointsEntity> sources =
                                logisticsPointsRepository.findByOrgId(seller.getOrgId());
                        Collection<LogisticsPointsEntity> destinations =
                                logisticsPointsRepository.findByOrgId(buyer.getOrgId());
                        for (LogisticsPointsEntity source : sources) {
                            for (LogisticsPointsEntity destination : destinations) {
                                orders.add(new OrdersEntity(
                                        "note " + i,
                                        orderStatus.getId(),
                                        buyer.getId(),
                                        seller.getId(),
                                        delivery.getId(),
                                        buyer.getPricePatternId(),
                                        source.getId(),
                                        destination.getId()));
                                i++;
                            }
                        }
                    }
                }
            }
        }
        ordersRepository.saveAll(orders);
        System.out.println("Add OrdersEntity: " + i);

        i = 0;
        List<UsersEntity> users = usersRepository.findAll();
        List<TraceOrdersEntity> traces = new ArrayList<>();
        Iterator<UsersEntity> userIterator = users.iterator();
        for (OrdersEntity order : orders) {
            for (OrderStatusesEntity status : orderStatuses) {
                if (!userIterator.hasNext()) {
                    userIterator = users.iterator();
                }

                UsersEntity user = userIterator.next();
                traces.add(new TraceOrdersEntity(
                        "note " + i, status.getId(), user.getId(), order.getId()));
                i++;
                if (status.getId().equals(order.getStatusId())) {
                    break;
                }
            }
        }
        traceOrdersRepository.saveAll(traces);
        System.out.println("Add TraceOrdersEntity: " + i);

        i = 0;
        List<OrdersProductsEntity> orderProducts = new ArrayList<>();
        for (SellersEntity seller : sellers) {
            UUID sellerId = seller.getId();
            Collection<OrdersEntity> sellerOrders = ordersRepository.findAllBySellerId(sellerId);
            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);
            Iterator<ProductsEntity> productsSellerIterator = sellerProducts.iterator();
            for (OrdersEntity order : sellerOrders) {
                for (int j = 0; j < muliplier; j++) {
                    if (!productsSellerIterator.hasNext()) {
                        productsSellerIterator = sellerProducts.iterator();
                    }
                    ProductsEntity product = productsSellerIterator.next();
                    orderProducts.add(new OrdersProductsEntity(
                            BigDecimal.valueOf(rnd.nextInt(10) + 1),
                            "note " + i,
                            order.getId(),
                            product.getId()));
                    i++;
                }
            }
        }
        ordersProductsRepository.saveAll(orderProducts);
        System.out.println("Add OrdersProductsEntity: " + i);

        i = 0;

        List<PricesEntity> prices = new ArrayList<>();
        for (SellersEntity seller : sellers) {
            UUID sellerId = seller.getId();
            Collection<PricePatternsEntity> sellerPatterns = pricePatternsRepository.findBySellerId(sellerId);
            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);

            for (PricePatternsEntity pattern : sellerPatterns) {
                for (ProductsEntity product : sellerProducts) {
                    BigDecimal cost = BigDecimal.valueOf(rnd.nextInt() * 100 + 1);
                    prices.add(new PricesEntity(cost, product.getId(), pattern.getId()));
                    i++;
                }
            }
        }
        pricesRepository.saveAll(prices);
        System.out.println("Add PricesEntity: " + i);

        i = 0;
        List<ExternalLinksEntity> links = new ArrayList<>();
        for (SellersEntity seller : sellers) {
            UUID sellerId = seller.getId();
            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);
            for (ProductsEntity product : sellerProducts) {
                links.add(new ExternalLinksEntity("code " + i, sellerId, product.getId()));
                i++;
            }
        }

        externalLinksRepository.saveAll(links);
        System.out.println("Add ExternalLinksEntity: " + i);

        System.out.println("Generate test data end.");
    }
}
