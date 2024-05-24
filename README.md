# SI_2024_lab2_196073
Vasil Dimitriev 196073
 
 2.Control Flow Graph
<br /> ![SI_2024_Lab2_196073_Graph](https://github.com/vasko2012/SI_2024_lab2_196073/assets/142700853/44b38e7e-fc11-4154-b6cd-3425a51ef1ca)


3. Цикломатска комплексност:
<br /> • Начин 1: Како што можеме да видиме графот има 36 ребра, 28 јазли и 1 сврзна компонента, па според формулата CC = E - N + 2P можеме да пресметаме дека цикломатската комплексност на графот е 36 - 28 + 2*1 = 10.
<br /> • Начин 2: Графот има 9 региони, па според формулата CC = R + 1 следува дека има 9 + 1 = 10 комплексност
<br /> • Начин 3: Графот содржи 9 предикатни јазли (7 if услови и 2 for циклуси), па според формулата CC = PN + 1 следува дека има 9 + 1 = 10 цикломатска комплексност

4. Тестирање со Every Branch критериум:
    <br /> • Тест случај 1: Листата allItems е null -> Листата не постои па со овој тест случај се препокрива првиот RuntimeException("allItems list can't be null!"), односно ќе се изминат ребрата: 1-2, 2-24.
   <br />&emsp; Објаснување: креираме exception со помош на изразот AssertThrows ја повикуваме функцијата SILab2.checkCart(null, 100) со аргументи null за листа и 100 за payment каде се фрла исклучок.
   <br /> • Тест случај 2: Производ без име и без баркод -> Производот има име „“ и нема баркод, баркодот не постои па со овој тест случај се препокрива третиот RuntimeException("No barcode!"), односно ќе се изминат ребрата: 1-3, 3-4.1, 4.1-4.2, 4.2-5, 5-6, 6-7, 7-8, 8-18, 18-24.
   <br />&emsp; Објаснување: креираме производ со „“ име и null баркод на следниот начин allItems.add(new Item("", null, 100, 0)), па со exception и со помош на изразот AssertThrows ја повикуваме функцијата SILab2.checkCart(allItems, 100) која ни фрла исклучок.
    <br /> • Тест случај 3: Производ со невалиден баркод -> Производот има невалиден баркод, во баркодот содржи буква па со овој тест случај се препокрива вториот RuntimeException("Invalid character in item barcode!"), односно ќе се изминат ребрата: 1-3, 3-4.1, 4.1-4.2, 4.2-5, 5-6, 6-8, 8-9, 9-10, 10-11.1, 11.1-11.2, 11.2-12, 12-13, 13-14, 14-24.
   <br />&emsp; Објаснување: креираме производ со и 12345а баркод на следниот начин allItems.add(new Item("item1", "12345a", 100, 0)), па со exception и со помош на изразот AssertThrows ја повикуваме функцијата SILab2.checkCart(allItems, 100) која ни фрла исклучок.
    <br /> • Тест случај 4: Производ со валиден баркод, без попуст ->  Со ова ќе се изминат ребрата: 1-3, 3-4.1, 4.1-4.2, 4.2-5, 5-6, 6-8, 8-9, 9-10, 10-11.1, 11.1-11.2, 11.2-12, 12-13, 13-11.3, 11.3-11.2, 11.2-15, 15-17, 17-19, 19-4.3, 4.3-4.2, 4.2-21, 21-22, 22-24.
   <br />&emsp; Објаснување: креираме производ со валиден баркод и со вредност 0 за попуст на следниот начин allItems.add(new Item("item1", "123456", 100, 0)), па со помош на изразот AssertTrue ја повикуваме функцијата SILab2.checkCart(allItems, 100).
    <br /> • Тест случај 5: Производ со валиден баркод, со цена>300, со попуст>0 и баркод што започнува со „0“ ->  Со ова ќе се изминат ребрата: 1-3, 3-4.1, 4.1-4.2, 4.2-5, 5-6, 6-8, 8-9, 9-10, 10-11.1, 11.1-11.2, 11.2-12, 12-13, 13-11.3, 11.3-11.2, 11.2-15, 15-16, 16-19, 19-20, 20-4.3, 4.3-4.2, 4.2-21, 21-23, 23-24.
   <br />&emsp; Објаснување: креираме производ со валиден баркод „012345“, со вредност 400 за цена и со вредност 0.2 (20%) за попуст на следниот начин allItems.add(new Item("item1", "012345", 400, 0.2f)), па со помош на изразот AssertTrue ја повикуваме функцијата SILab2.checkCart(allItems, 100) со аргументи allItems за листа и 100 за payment.

   5.Тестирање со Multiple condition критериум:
    ![SI_2024_Lab2_196073_Table](https://github.com/vasko2012/SI_2024_lab2_196073/assets/142700853/c60ce582-1ced-422a-badc-f43d56b04c5d)

   <br /> Објаснување: На променливите им задаваме вредности така што одговараат на вистинитосните вредности наведени во табелата.