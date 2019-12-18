//package stc21.smartmediator;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.postgresql.util.PGmoney;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import stc21.smartmediator.entity.*;
//import stc21.smartmediator.repository.*;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.*;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApplicdeleteDataation.class)
//public class DataGeneratorTest {
//
//    @Autowired
//    private OrgStatusesRepository orgStatusesRepository;
//
//    @Autowired
//    private OrganizationsRepository organizationsRepository;
//
//    @Autowired
//    private SellersRepository sellersRepository;
//
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @Autowired
//    private OrderStatusesRepository orderStatusesRepository;
//
//    @Autowired
//    private DeliveryTypesRepository deliveryTypesRepository;
//
//    @Autowired
//    private UserStatusesRepository userStatusesRepository;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private UsersOrganizationsRepository usersOrganizationsRepository;
//
//    @Autowired
//    private PricePatternsRepository pricePatternsRepository;
//
//    @Autowired
//    private BuyersRepository buyersRepository;
//
//    @Autowired
//    private LogisticsPointsRepository logisticsPointsRepository;
//
//    @Autowired
//    private ProductsTypesRepository productsTypesRepository;
//
//    @Autowired
//    private UnitsRepository unitsRepository;
//
//    @Autowired
//    private ProductsRepository productsRepository;
//
//    @Autowired
//    private OrdersRepository ordersRepository;
//
//    @Autowired
//    private TraceOrdersRepository traceOrdersRepository;
//
//    @Autowired
//    private OrdersProductsRepository ordersProductsRepository;
//
//    @Autowired
//    private PricesRepository pricesRepository;
//
//    @Autowired
//    private ExternalLinksRepository externalLinksRepository;
//
//    @Autowired
//    private UsersRolesRepository usersRolesRepository;
//
//    private ArrayList<OrganizationsEntity> getOrgs(List<OrgStatusesEntity> statuses, int count, int i) {
//        ArrayList<OrganizationsEntity> orgs = new ArrayList<>();
//        for (OrgStatusesEntity status : Collections.unmodifiableList(statuses)) {
//            for (int j = 0; j < count; j++) {
//                OrganizationsEntity organization = new OrganizationsEntity(
//                        "Full name " + i, "name " + i, "inn " + i, "address" + i, status.getId());
//                orgs.add(organization);
//                i++;
//            }
//        }
//        return orgs;
//    }
//
//    @Test
//    public void InsertTest() throws SQLException {
//
//        externalLinksRepository.deleteAll();
//        pricesRepository.deleteAll();
//        ordersProductsRepository.deleteAll();
//        traceOrdersRepository.deleteAll();
//        ordersRepository.deleteAll();
//        logisticsPointsRepository.deleteAll();
//        productsRepository.deleteAll();
//        buyersRepository.deleteAll();
//        pricePatternsRepository.deleteAll();
//        sellersRepository.deleteAll();
//        usersOrganizationsRepository.deleteAll();
//        organizationsRepository.deleteAll();
//        usersRepository.deleteAll();
//        orgStatusesRepository.deleteAll();
//        userStatusesRepository.deleteAll();
//        rolesRepository.deleteAll();
//        orderStatusesRepository.deleteAll();
//        deliveryTypesRepository.deleteAll();
//        unitsRepository.deleteAll();
//        productsTypesRepository.deleteAll();
//        usersRolesRepository.deleteAll();
//
//        OrgStatusesEntity os = new OrgStatusesEntity("new", "Новая");
//        OrgStatusesEntity newOrgStatus = orgStatusesRepository.save(os);
//        os = new OrgStatusesEntity("wait", "Ожидает");
//        OrgStatusesEntity waitOrgStatus = orgStatusesRepository.save(os);
//        os = new OrgStatusesEntity("confirm", "Подтверждена");
//        OrgStatusesEntity confirmOrgStatus = orgStatusesRepository.save(os);
//        os = new OrgStatusesEntity("ban", "Забанена");
//        OrgStatusesEntity banOrgStatus = orgStatusesRepository.save(os);
//
//        List<OrgStatusesEntity> statuses = orgStatusesRepository.findAll();
//
//        assertEquals(4, statuses.size());
//
//        List<UserStatusesEntity> userStatuses = new ArrayList<>();
//        userStatuses.add(new UserStatusesEntity("new", "Новая"));
//        userStatuses.add(new UserStatusesEntity("wait", "Ожидает"));
//        userStatuses.add(new UserStatusesEntity("confirm", "Подтверждена"));
//        userStatuses.add(new UserStatusesEntity("ban", "Забанена"));
//        userStatusesRepository.saveAll(userStatuses);
//
//        userStatuses = userStatusesRepository.findAll();
//        assertEquals(4, userStatuses.size());
//
//        RolesEntity r = new RolesEntity("user", "Пользователь");
//        rolesRepository.save(r);
//        r = new RolesEntity("admin", "Администратор");
//        rolesRepository.save(r);
//
//        List<RolesEntity> roles = rolesRepository.findAll();
//
//        assertEquals(2, roles.size());
//
//        List<OrderStatusesEntity> orderStatuses = new ArrayList<>();
//        orderStatuses.add(new OrderStatusesEntity("draft", "Черновик"));
//        orderStatuses.add(new OrderStatusesEntity("new", "Новый"));
//        orderStatuses.add(new OrderStatusesEntity("cancel", "Отменен"));
//        orderStatuses.add(new OrderStatusesEntity("taken", "Подтвержден"));
//        orderStatuses.add(new OrderStatusesEntity("shipped", "Отправлен"));
//        orderStatuses.add(new OrderStatusesEntity("delivered", "Доставлен"));
//        orderStatuses.add(new OrderStatusesEntity("lost", "Потерян"));
//        orderStatusesRepository.saveAll(orderStatuses);
//
//        orderStatuses = orderStatusesRepository.findAll();
//        assertEquals(7, orderStatuses.size());
//
//        DeliveryTypesEntity dt = new DeliveryTypesEntity("pickup", "Самовывоз");
//        deliveryTypesRepository.save(dt);
//        dt = new DeliveryTypesEntity("supply", "Доставка");
//        deliveryTypesRepository.save(dt);
//
//        List<DeliveryTypesEntity> deliveryTypes = deliveryTypesRepository.findAll();
//        assertEquals(2, deliveryTypes.size());
//
//        int i = 0;
//        int count = 2;
//        int totalOrgCount = statuses.size() * count * 2;
//
//        ArrayList<OrganizationsEntity> sellerOrgs = getOrgs(statuses, count, 0);
//        ArrayList<OrganizationsEntity> buyerOrgs = getOrgs(statuses, count, sellerOrgs.size());
//        organizationsRepository.saveAll(sellerOrgs);
//        organizationsRepository.saveAll(buyerOrgs);
//
//        List<OrganizationsEntity> orgs = organizationsRepository.findAll();
//
//        assertEquals(totalOrgCount, orgs.size());
//
//        i = 0;
//        for (OrganizationsEntity org : sellerOrgs) {
//            SellersEntity seller = new SellersEntity(org.getId());
//            sellersRepository.save(seller);
//        }
//
//        List<SellersEntity> sellers = sellersRepository.findAll();
//
//        assertEquals(sellerOrgs.size(), sellers.size());
//
//        UUID userRoleId = rolesRepository.findByCode("user").getId();
//
//        List<UsersOrganizationsEntity> usersOrganizations = new ArrayList<>();
//        i = 0;
//        for (UserStatusesEntity userStatus : userStatuses) {
//            for (OrganizationsEntity org : orgs) {
//                for (int j = 0; j < count; j++) {
//                    UsersEntity newUser = usersRepository.save(new UsersEntity(
//                            "email " + i,
//                            "password hash" + i,
//                            "full name" + i,
////                            userRoleId,
//                            userStatus.getId(),
//                            true));
//                    usersOrganizations.add(new UsersOrganizationsEntity(newUser.getId(), org.getId()));
//                    i++;
//                    usersRolesRepository.save(new UsersRolesEntity(newUser.getId(),"ADMIN"));
//                }
//            }
//        }
//
//        usersOrganizationsRepository.saveAll(usersOrganizations);
//
//        int totalUsers = userStatuses.size() * orgs.size() * count;
//        List<UsersEntity> users = usersRepository.findAll();
//        assertEquals(totalUsers, users.size());
//
//        usersOrganizations = usersOrganizationsRepository.findAll();
//        assertEquals(totalUsers, usersOrganizations.size());
//
//        i = 0;
//        List<PricePatternsEntity> patterns = new ArrayList<>();
//        for (SellersEntity seller : sellers) {
//            for (int j = 0; j < count; j++) {
//                patterns.add(new PricePatternsEntity(
//                        "code " + i, "name " + i, null, "note " + i, seller.getId()));
//                i++;
//            }
//        }
//
//        pricePatternsRepository.saveAll(patterns);
//        List<PricePatternsEntity> childPatterns = new ArrayList<>();
//        for (PricePatternsEntity parent : patterns) {
//            for (int j = 0; j < count; j++) {
//                childPatterns.add(new PricePatternsEntity(
//                        "code " + i, "name " + i, parent.getId(), "note " + i, parent.getSellerId()));
//                i++;
//            }
//        }
//
//        pricePatternsRepository.saveAll(childPatterns);
//        patterns = pricePatternsRepository.findAll();
//        assertEquals(i, patterns.size());
//
//        i = 0;
//        List<BuyersEntity> buyers = new ArrayList<>();
//        int buyerCount = Math.min(buyerOrgs.size(), patterns.size());
//        Iterator<OrganizationsEntity> orgIterator = buyerOrgs.iterator();
//        Iterator<PricePatternsEntity> patternsIterator = patterns.iterator();
//        for (int j = 0; j < buyerCount; j++) {
//            PricePatternsEntity pattern = patternsIterator.next();
//            OrganizationsEntity org = orgIterator.next();
//            buyers.add(new BuyersEntity(org.getId(), pattern.getId()));
//        }
//
//        buyersRepository.saveAll(buyers);
//        buyers = buyersRepository.findAll();
//        assertEquals(buyerCount, buyers.size());
//
//        i = 0;
//        List<LogisticsPointsEntity> points = new ArrayList<>();
//        for(OrganizationsEntity org : orgs) {
//            for(int j = 0; j < count; j++) {
//                points.add(new LogisticsPointsEntity(
//                        "code " + i, "name " + i, "address " + i, org.getId()));
//                i++;
//            }
//        }
//        logisticsPointsRepository.saveAll(points);
//        int pointsTotal = totalOrgCount * count;
//        points = logisticsPointsRepository.findAll();
//        assertEquals(pointsTotal, points.size());
//
//        i = 0;
//        List<ProductsTypesEntity> productTypes = new ArrayList<>();
//        for(int j = 0; j < count; j++) {
//            productTypes.add(new ProductsTypesEntity("code " + i, "name " + i));
//            i++;
//        }
//        productsTypesRepository.saveAll(productTypes);
//
//        i = 0;
//        List<UnitsEntity> units = new ArrayList<>();
//        for(int j = 0; j < count; j++) {
//            units.add(new UnitsEntity("code " + i, "name " + i));
//            i++;
//        }
//        unitsRepository.saveAll(units);
//
//        i = 0;
//        List<ProductsEntity> products = new ArrayList<>();
//        Random rnd = new Random();
//        for(SellersEntity seller : sellers) {
//            for(ProductsTypesEntity productType : productTypes) {
//                for(UnitsEntity unit : units) {
//                    for(int j = 0; j < count; j++) {
//                        products.add(new ProductsEntity(
//                                "code " + i,
//                                "name " + i,
//                                BigDecimal.valueOf(rnd.nextInt(100)),
//                                "note " + i,
//                                unit.getId(),
//                                productType.getId(),
//                                seller.getId()));
//                        i++;
//                    }
//                }
//            }
//        }
//        products = productsRepository.saveAll(products);
//        int productsCount = sellers.size() * units.size() * productTypes.size() * count;
//        assertEquals(productsCount, products.size());
//
//        i = 0;
//        List<OrdersEntity> orders = new ArrayList<>();
//        for(OrderStatusesEntity orderStatus : orderStatuses) {
//            for(DeliveryTypesEntity delivery : deliveryTypes) {
//                for(SellersEntity seller : sellers) {
//                    for(BuyersEntity buyer : buyers) {
//                        Collection<LogisticsPointsEntity> sources =
//                                logisticsPointsRepository.findByOrgId(seller.getOrgId());
//                        Collection<LogisticsPointsEntity> destinations =
//                                logisticsPointsRepository.findByOrgId(buyer.getOrgId());
//                        for(LogisticsPointsEntity source : sources) {
//                            for(LogisticsPointsEntity destination : destinations) {
//                                orders.add(new OrdersEntity(
//                                        "note " + i,
//                                        //FIXME
//                                        orderStatus,
//                                        buyer.getId(),
//                                        seller.getId(),
//                                        delivery.getId(),
//                                        buyer.getPricePatternId(),
//                                        source.getId(),
//                                        destination.getId()));
//                                i++;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        ordersRepository.saveAll(orders);
//        orders = ordersRepository.findAll();
//        assertEquals(i, orders.size());
//
//        i = 0;
//        List<TraceOrdersEntity> traces = new ArrayList<>();
//        Iterator<UsersEntity> userIterator = users.iterator();
//        for(OrdersEntity order : orders) {
//            for(OrderStatusesEntity status : orderStatuses) {
//                if(!userIterator.hasNext()) {
//                    userIterator = users.iterator();
//                }
//
//                UsersEntity user = userIterator.next();
//                traces.add(new TraceOrdersEntity(
//                        "note " + i, status.getId(), user.getId(), order.getId()));
//                i++;
//                if(status.getId().equals(order.getStatusId())) {
//                    break;
//                }
//            }
//        }
//        traceOrdersRepository.saveAll(traces);
//        traces = traceOrdersRepository.findAll();
//        assertEquals(i, traces.size());
//
//        i = 0;
//        List<OrdersProductsEntity> orderProducts = new ArrayList<>();
//        for(SellersEntity seller : sellers) {
//            UUID sellerId = seller.getId();
//            Collection<OrdersEntity> sellerOrders = ordersRepository.findAllBySellerId(sellerId);
//            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);
//            Iterator<ProductsEntity> productsSellerIterator = sellerProducts.iterator();
//            for (OrdersEntity order : sellerOrders) {
//                for (int j = 0; j < count; j++) {
//                    if (!productsSellerIterator.hasNext()) {
//                        productsSellerIterator = sellerProducts.iterator();
//                    }
//                    ProductsEntity product = productsSellerIterator.next();
//                    orderProducts.add(new OrdersProductsEntity(
//                                BigDecimal.valueOf(rnd.nextInt(10) + 1),
//                                "note " + i,
//                                order.getId(),
//                                product.getId()));
//                    i++;
//                }
//            }
//        }
//        ordersProductsRepository.saveAll(orderProducts);
//        orderProducts = ordersProductsRepository.findAll();
//        assertEquals(i, orderProducts.size());
//
//        i = 0;
//
//        List<PricesEntity> prices = new ArrayList<>();
//        for(SellersEntity seller : sellers) {
//            UUID sellerId = seller.getId();
//            Collection<PricePatternsEntity> sellerPatterns = pricePatternsRepository.findBySellerId(sellerId);
//            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);
//
//            for(PricePatternsEntity pattern : sellerPatterns) {
//                for(ProductsEntity product : sellerProducts) {
//                    BigDecimal cost = BigDecimal.valueOf(rnd.nextInt() * 100 + 1);
//                    prices.add(new PricesEntity(cost, product.getId(), pattern.getId()));
//                    i++;
//                }
//            }
//        }
//        pricesRepository.saveAll(prices);
//        prices = pricesRepository.findAll();
//        assertEquals(i, prices.size());
//
//        i = 0;
//        List<ExternalLinksEntity> links = new ArrayList<>();
//        for(SellersEntity seller : sellers) {
//            UUID sellerId = seller.getId();
//            Collection<ProductsEntity> sellerProducts = productsRepository.findAllBySellerId(sellerId);
//            for(ProductsEntity product : sellerProducts) {
//                links.add(new ExternalLinksEntity("code " + i, sellerId, product.getId()));
//                i++;
//            }
//        }
//
//        externalLinksRepository.saveAll(links);
//        links = externalLinksRepository.findAll();
//        assertEquals(i, links.size());
//    }
//}
