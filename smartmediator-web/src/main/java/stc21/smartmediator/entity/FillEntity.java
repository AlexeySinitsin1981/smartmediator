package stc21.smartmediator.entity;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import stc21.smartmediator.repository.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillEntity {

    private final UserStatusesRepository userStatusesRepository;
    private final UsersRepository usersRepository;
    private final UsersRolesRepository usersRolesRepository;
    private final OrgStatusesRepository orgStatusesRepository;
    private final OrganizationsRepository organizationsRepository;
    private final UsersOrganizationsRepository usersOrganizationsRepository;
    private final SellersRepository sellersRepository;
    private final BuyersRepository buyersRepository;
    private final PricePatternsRepository pricePatternsRepository;
    private final ProductsTypesRepository productsTypesRepository;
    private final ProductsRepository productsRepository;
    private final UnitsRepository unitsRepository;
    private final PricesRepository pricesRepository;
    private final OrderStatusesRepository orderStatusesRepository;
    private final DeliveryTypesRepository deliveryTypesRepository;
    private final LogisticsPointsRepository logisticsPointsRepository;
    private final OrdersRepository ordersRepository;
    private final OrdersProductsRepository ordersProductsRepository;

    public FillEntity(UserStatusesRepository userStatusesRepository,
                      UsersRepository usersRepository, UsersRolesRepository usersRolesRepository, OrgStatusesRepository orgStatusesRepository, OrganizationsRepository organizationsRepository, UsersOrganizationsRepository usersOrganizationsRepository, SellersRepository sellersRepository, BuyersRepository buyersRepository, PricePatternsRepository pricePatternsRepository, ProductsTypesRepository productsTypesRepository, ProductsRepository productsRepository, UnitsRepository unitsRepository, PricesRepository pricesRepository, OrderStatusesRepository orderStatusesRepository, DeliveryTypesRepository deliveryTypesRepository, LogisticsPointsRepository logisticsPointsRepository, OrdersRepository ordersRepository, OrdersProductsRepository ordersProductsRepository) {
        this.userStatusesRepository = userStatusesRepository;
        this.usersRepository = usersRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.orgStatusesRepository = orgStatusesRepository;
        this.organizationsRepository = organizationsRepository;
        this.usersOrganizationsRepository = usersOrganizationsRepository;
        this.sellersRepository = sellersRepository;
        this.buyersRepository = buyersRepository;
        this.pricePatternsRepository = pricePatternsRepository;
        this.productsTypesRepository = productsTypesRepository;
        this.productsRepository = productsRepository;
        this.unitsRepository = unitsRepository;
        this.pricesRepository = pricesRepository;
        this.orderStatusesRepository = orderStatusesRepository;
        this.deliveryTypesRepository = deliveryTypesRepository;
        this.logisticsPointsRepository = logisticsPointsRepository;
        this.ordersRepository = ordersRepository;
        this.ordersProductsRepository = ordersProductsRepository;
    }

    public void clearData() {

    }

    public void fillData() {

        UserStatusesEntity verifyState = new UserStatusesEntity("confirm", "Подтверждён");

        DeliveryTypesEntity supply = new DeliveryTypesEntity("supply", "Доставка");
        deliveryTypesRepository.save(supply);

        List<OrderStatusesEntity> orderStatusesEntities = new ArrayList<>();

        OrderStatusesEntity oNew = new OrderStatusesEntity("new", "Новый");
        OrderStatusesEntity oConfirm = new OrderStatusesEntity("confirm", "Подтвержден");
        OrderStatusesEntity oCancel = new OrderStatusesEntity("cancel", "Отменен");
        OrderStatusesEntity oDelivered = new OrderStatusesEntity("delivered", "Доставлен");

        orderStatusesEntities.add(oNew);
        orderStatusesEntities.add(oConfirm);
        orderStatusesEntities.add(oCancel);
        orderStatusesEntities.add(oDelivered);
        orderStatusesRepository.saveAll(orderStatusesEntities);

        List<UserStatusesEntity> statuses = new ArrayList<>();
        statuses.add(new UserStatusesEntity("new", "Новый"));
        statuses.add(new UserStatusesEntity("wait", "Ожидает"));
        statuses.add(verifyState);
        statuses.add(new UserStatusesEntity("ban", "Забанен"));
        userStatusesRepository.saveAll(statuses);

        List<OrgStatusesEntity> orgStatusesEntities = new ArrayList<>();
        OrgStatusesEntity orgStatusesEntity = new OrgStatusesEntity("new", "Новый");
        orgStatusesEntities.add(orgStatusesEntity);
        orgStatusesRepository.saveAll(orgStatusesEntities);

        List<UsersEntity> usersEntities = new ArrayList<>();
        UsersEntity admin = new UsersEntity("ema1@ema.ru", "123",
                "admin", verifyState.getId(), true);
        UsersEntity buy = new UsersEntity("ema2@ema.ru", "123",
                "buy", verifyState.getId(), true);
        UsersEntity sell = new UsersEntity("ema3@ema.ru", "123",
                "sell", verifyState.getId(), true);
        usersEntities.add(admin);
        usersEntities.add(buy);
        usersEntities.add(sell);
        usersRepository.saveAll(usersEntities);

        List<UsersRolesEntity> usersRolesEntities = new ArrayList<>();
        usersRolesEntities.add(new UsersRolesEntity(admin.getId(), "ADMIN"));
        usersRolesEntities.add(new UsersRolesEntity(buy.getId(), "BUYER"));
        usersRolesEntities.add(new UsersRolesEntity(sell.getId(), "SELLER"));
        usersRolesRepository.saveAll(usersRolesEntities);

        List<OrganizationsEntity> organizationsEntities = new ArrayList<>();
        OrganizationsEntity rogok = new OrganizationsEntity("AO Рожок",
                "AO Рожок", "1234599999011450",
                "Пр. Ленина 45", orgStatusesEntity.getId());

        OrganizationsEntity mag = new OrganizationsEntity("ООО Магнезит",
                "ООО Магнезит", "1234567891011450",
                "Ул. Мира 61", orgStatusesEntity.getId());

        OrganizationsEntity knopka = new OrganizationsEntity("ООО Кнопка",
                "ООО Кнопка", "6598465891011450",
                "Пр. Баумана 85", orgStatusesEntity.getId());

        organizationsEntities.add(rogok);
        organizationsEntities.add(mag);
        organizationsEntities.add(knopka);

        organizationsRepository.saveAll(organizationsEntities);

        UsersOrganizationsEntity uo1 = new UsersOrganizationsEntity();
        usersOrganizationsRepository.save(uo1);
        uo1.setUser(admin);
        uo1.setOrg(rogok);
        usersOrganizationsRepository.save(uo1);

        UsersOrganizationsEntity uo2 = new UsersOrganizationsEntity();
        usersOrganizationsRepository.save(uo2);
        uo2.setUser(buy);
        uo2.setOrg(mag);
        usersOrganizationsRepository.save(uo2);

        UsersOrganizationsEntity uo3 = new UsersOrganizationsEntity();
        usersOrganizationsRepository.save(uo3);
        uo3.setUser(sell);
        uo3.setOrg(knopka);
        usersOrganizationsRepository.save(uo3);

        SellersEntity sellersEntity = new SellersEntity();
        sellersRepository.save(sellersEntity);
        sellersEntity.setOrg(rogok);
        sellersRepository.save(sellersEntity);

        PricePatternsEntity pricePatternsEntity = new PricePatternsEntity("magnit", "Магнит",
                null, "", sellersEntity.getId());
        pricePatternsRepository.save(pricePatternsEntity);

        BuyersEntity buyer = new BuyersEntity();
        buyersRepository.save(buyer);
        buyer.setPricePatternId(pricePatternsEntity.getId());
        buyer.setOrg(mag);
        buyersRepository.save(buyer);

        ProductsTypesEntity productsTypesEntity = new ProductsTypesEntity("code", "code");
        productsTypesRepository.save(productsTypesEntity);

        UnitsEntity unitsEntity = new UnitsEntity("it", "шт");
        unitsRepository.save(unitsEntity);

        UnitsEntity unitsEntityLitr = new UnitsEntity("litr", "литр");
        unitsRepository.save(unitsEntity);

        ProductsEntity p1 = new ProductsEntity();
        productsRepository.save(p1);
        p1.setCode("1");
        p1.setName("Молоко");
        p1.setQuantity(BigDecimal.valueOf(5000));
        p1.setNote("");
        p1.setUnit(unitsEntity);
        p1.setProductTypeId(productsTypesEntity.getId());
        p1.setSellerId(sellersEntity.getId());
        p1.setPrice(BigDecimal.valueOf(34));
        productsRepository.save(p1);

        ProductsEntity p2 = new ProductsEntity();
        productsRepository.save(p2);
        p2.setCode("2");
        p2.setName("Хлеб");
        p2.setQuantity(BigDecimal.valueOf(5000));
        p2.setNote("");
        p2.setUnit(unitsEntity);
        p2.setProductTypeId(productsTypesEntity.getId());
        p2.setSellerId(sellersEntity.getId());
        p2.setPrice(BigDecimal.valueOf(75));
        productsRepository.save(p2);

        ProductsEntity p3 = new ProductsEntity();
        productsRepository.save(p3);
        p3.setCode("3");
        p3.setName("Кефир");
        p3.setQuantity(BigDecimal.valueOf(5000));
        p3.setNote("");
        p3.setUnit(unitsEntity);
        p3.setProductTypeId(productsTypesEntity.getId());
        p3.setSellerId(sellersEntity.getId());
        p3.setPrice(BigDecimal.valueOf(94));
        productsRepository.save(p3);

        ProductsEntity p4 = new ProductsEntity();
        productsRepository.save(p4);
        p4.setCode("4");
        p4.setName("Кумыс");
        p4.setQuantity(BigDecimal.valueOf(5000));
        p4.setNote("");
        p4.setUnit(unitsEntity);
        p4.setProductTypeId(productsTypesEntity.getId());
        p4.setSellerId(sellersEntity.getId());
        p4.setPrice(BigDecimal.valueOf(534));
        productsRepository.save(p4);

        ProductsEntity p5 = new ProductsEntity();
        productsRepository.save(p5);
        p5.setCode("5");
        p5.setName("Сметана");
        p5.setQuantity(BigDecimal.valueOf(5000));
        p5.setNote("");
        p5.setUnit(unitsEntity);
        p5.setProductTypeId(productsTypesEntity.getId());
        p5.setSellerId(sellersEntity.getId());
        p5.setPrice(BigDecimal.valueOf(999));
        productsRepository.save(p5);

        ProductsEntity p6 = new ProductsEntity();
        productsRepository.save(p6);
        p6.setCode("6");
        p6.setName("Сыр");
        p6.setQuantity(BigDecimal.valueOf(5000));
        p6.setNote("");
        p6.setUnit(unitsEntity);
        p6.setProductTypeId(productsTypesEntity.getId());
        p6.setSellerId(sellersEntity.getId());
        p6.setPrice(BigDecimal.valueOf(500));
        productsRepository.save(p6);


        List<PricesEntity> pricesEntities = new ArrayList<>();
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(45), p1.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p2.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(96), p3.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(23), p4.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(98), p5.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p6.getId(), pricePatternsEntity.getId()));
        pricesRepository.saveAll(pricesEntities);

        LogisticsPointsEntity logis = new LogisticsPointsEntity("point", "Точка обмена", "Бейкер стрит 221", mag.getId());
        logisticsPointsRepository.save(logis);

        int n = 15000;

        OrdersEntity o1 = new OrdersEntity();
        ordersRepository.save(o1);
        o1.setStatus(oNew);
        o1.setBuyer(buyer);
        o1.setSeller(sellersEntity);
        o1.setSeller(sellersEntity);
        o1.setDeliveryTypeId(supply.getId());
        o1.setPricePatternId(pricePatternsEntity.getId());
        o1.setGetFrom(logis.getId());
        o1.setSetTo(logis.getId());
        o1.setNumber(BigDecimal.valueOf(n++));
        o1.setPrice(BigDecimal.valueOf(45851));
        o1.setCreateDate(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(o1);

        OrdersEntity o2 = new OrdersEntity();
        ordersRepository.save(o2);
        o2.setStatus(oNew);
        o2.setBuyer(buyer);
        o2.setSeller(sellersEntity);
        o2.setSeller(sellersEntity);
        o2.setDeliveryTypeId(supply.getId());
        o2.setPricePatternId(pricePatternsEntity.getId());
        o2.setGetFrom(logis.getId());
        o2.setSetTo(logis.getId());
        o2.setNumber(BigDecimal.valueOf(n++));
        o2.setPrice(BigDecimal.valueOf(34245));
        o2.setCreateDate(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(o2);

        OrdersEntity o3 = new OrdersEntity();
        ordersRepository.save(o3);
        o3.setStatus(oNew);
        o3.setBuyer(buyer);
        o3.setSeller(sellersEntity);
        o3.setSeller(sellersEntity);
        o3.setDeliveryTypeId(supply.getId());
        o3.setPricePatternId(pricePatternsEntity.getId());
        o3.setGetFrom(logis.getId());
        o3.setSetTo(logis.getId());
        o3.setNumber(BigDecimal.valueOf(n++));
        o3.setPrice(BigDecimal.valueOf(7234));
        o3.setCreateDate(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(o3);

        OrdersEntity o4 = new OrdersEntity();
        ordersRepository.save(o4);
        o4.setStatus(oNew);
        o4.setBuyer(buyer);
        o4.setSeller(sellersEntity);
        o4.setSeller(sellersEntity);
        o4.setDeliveryTypeId(supply.getId());
        o4.setPricePatternId(pricePatternsEntity.getId());
        o4.setGetFrom(logis.getId());
        o4.setSetTo(logis.getId());
        o4.setNumber(BigDecimal.valueOf(n++));
        o4.setPrice(BigDecimal.valueOf(968765));
        o4.setCreateDate(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(o4);

        OrdersEntity o5 = new OrdersEntity();
        ordersRepository.save(o5);
        o5.setStatus(oNew);
        o5.setBuyer(buyer);
        o5.setSeller(sellersEntity);
        o5.setSeller(sellersEntity);
        o5.setDeliveryTypeId(supply.getId());
        o5.setPricePatternId(pricePatternsEntity.getId());
        o5.setGetFrom(logis.getId());
        o5.setSetTo(logis.getId());
        o5.setNumber(BigDecimal.valueOf(n++));
        o5.setPrice(BigDecimal.valueOf(41347));
        o5.setCreateDate(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(o5);

        OrdersProductsEntity s1 = new OrdersProductsEntity();
        ordersProductsRepository.save(s1);
        s1.setAmount(BigDecimal.valueOf(782));
        s1.setPrice(BigDecimal.valueOf(92));
        s1.setNote("");
        s1.setOrder(o1);
        s1.setProduct(p1);
        ordersProductsRepository.save(s1);

        OrdersProductsEntity s2 = new OrdersProductsEntity();
        ordersProductsRepository.save(s2);
        s2.setAmount(BigDecimal.valueOf(902));
        s2.setPrice(BigDecimal.valueOf(45));
        s2.setNote("");
        s2.setOrder(o1);
        s2.setProduct(p2);
        ordersProductsRepository.save(s2);

        OrdersProductsEntity s3 = new OrdersProductsEntity();
        ordersProductsRepository.save(s3);
        s3.setAmount(BigDecimal.valueOf(128));
        s3.setPrice(BigDecimal.valueOf(635));
        s3.setNote("");
        s3.setOrder(o1);
        s3.setProduct(p3);
        ordersProductsRepository.save(s3);

        OrdersProductsEntity s4 = new OrdersProductsEntity();
        ordersProductsRepository.save(s4);
        s4.setAmount(BigDecimal.valueOf(112));
        s4.setPrice(BigDecimal.valueOf(325));
        s4.setNote("");
        s4.setOrder(o1);
        s4.setProduct(p4);
        ordersProductsRepository.save(s4);

    }

}
