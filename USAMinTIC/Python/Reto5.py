def inventory_total(store):
    value = 0
    for i in store:
        value += store[i][1]*store[i][2]
    return value


def prom_prices(store):
    prom = 0
    for i in store:
        prom += store[i][1]
    prom /= len(store)
    return prom


def name_price_less(store):
    keys = list(store.keys())
    less_price = store[keys[0]][1]
    name_less = store[keys[0]][0]
    for i in store:
        if store[i][1] < less_price:
            less_price = store[i][1]
            name_less = store[i][0]
    return name_less


def name_price_higher(store):
    keys = list(store.keys())
    higher_price = store[keys[0]][1]
    name_higher = store[keys[0]][0]
    for i in store:
        if store[i][1] > higher_price:
            higher_price = store[i][1]
            name_higher = store[i][0]
    return name_higher


def update_product(store, product):
    if product[0] in store:
        code = product[0]
        product.pop(0)
        store[code] = product
        return True
    else:
        return False


def delete_product(store, product):
    if product[0] in store:
        store.pop(product[0])
        return True
    else:
        return False


def add_product(store, product):
    if product[0] in store:
        return False
    else:
        code = product[0]
        product.pop(0)
        store[code] = product
        return True


def read_data():
    operation = input()
    product = input().split()
    product[0] = int(product[0])
    product[2] = float(product[2])
    product[3] = int(product[3])
    return operation, product


def start():
    store = {1: ['Manzanas', 6000.0, 97],
             2: ['Limones', 2600.0, 45],
             3: ['Peras', 2700.0, 45],
             4: ['Arandanos', 7300.0, 44],
             5: ['Tomates', 8100.0, 42],
             6: ['Fresas', 9100.0, 99],
             7: ['Helado', 4500.0, 41],
             8: ['Galletas', 600.0, 18],
             9: ['Chocolates', 4500.0, 990],
             10: ['Jamon', 18000.0, 55]}

    operation, product = read_data()
    if operation == 'AGREGAR':
        bandera = add_product(store, product)
    elif operation == 'BORRAR':
        bandera = delete_product(store, product)
    elif operation == 'ACTUALIZAR':
        bandera = update_product(store, product)

    if bandera:
        print(name_price_higher(store), name_price_less(store), round(
            prom_prices(store), 1), round(inventory_total(store), 1))
    else:
        print('ERROR')


start()
