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

        List<UsersOrganizationsEntity> usersOrganizationsEntities = new ArrayList<>();
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(admin.getId(), rogok.getId()));
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(buy.getId(), mag.getId()));
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(sell.getId(), knopka.getId()));
        usersOrganizationsRepository.saveAll(usersOrganizationsEntities);

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

        List<ProductsEntity> productsEntities = new ArrayList<>();

        ProductsEntity p1 = new ProductsEntity("1", "Молоко", BigDecimal.valueOf(5000), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p2 = new ProductsEntity("2", "Хлеб", BigDecimal.valueOf(230), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p3 = new ProductsEntity("3", "Кефир", BigDecimal.valueOf(7600), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p4 = new ProductsEntity("4", "Кумыс", BigDecimal.valueOf(130), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p5 = new ProductsEntity("5", "Сметана", BigDecimal.valueOf(450), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p6 = new ProductsEntity("6", "Сыр", BigDecimal.valueOf(7890), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p7 = new ProductsEntity("7", "Ряженка", BigDecimal.valueOf(5660), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p8 = new ProductsEntity("8", "Катык", BigDecimal.valueOf(9900), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());

        productsEntities.add(p1);
        productsEntities.add(p2);
        productsEntities.add(p3);
        productsEntities.add(p4);
        productsEntities.add(p5);
        productsEntities.add(p6);
        productsEntities.add(p7);
        productsEntities.add(p8);
        productsRepository.saveAll(productsEntities);

        List<PricesEntity> pricesEntities = new ArrayList<>();
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(45), p1.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p2.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(96), p3.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(23), p4.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(98), p5.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p6.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(90), p7.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(25), p8.getId(), pricePatternsEntity.getId()));
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

        List<OrdersProductsEntity> ordersProductsEntities = new ArrayList<>();
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(12), "", o1.getId(), p1.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(43), "", o1.getId(), p2.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(32), "", o1.getId(), p3.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(5), "", o1.getId(), p4.getId()));

        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(122), "", o2.getId(), p1.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(433), "", o2.getId(), p2.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(352), "", o2.getId(), p3.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(56), "", o2.getId(), p4.getId()));

        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(912), "", o3.getId(), p1.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(643), "", o3.getId(), p2.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(532), "", o3.getId(), p3.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(35), "", o3.getId(), p4.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(712), "", o3.getId(), p5.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(3), "", o3.getId(), p6.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(92), "", o3.getId(), p7.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(565), "", o3.getId(), p8.getId()));

        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(905), "", o4.getId(), p5.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(7), "", o4.getId(), p1.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(81), "", o4.getId(), p4.getId()));

        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(1), "", o5.getId(), p1.getId()));
        ordersProductsEntities.add(new OrdersProductsEntity(BigDecimal.valueOf(1), "", o5.getId(), p3.getId()));

        ordersProductsRepository.saveAll(ordersProductsEntities);
    }

}
