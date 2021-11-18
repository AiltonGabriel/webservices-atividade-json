import requests

# Cache que armazena as respostas de cada chamada, de modo que uma chamada a uma URL da API que já tenha sido realizada 
# não envolva comunicação de rede, retornando a resposta já armazenada.
cache = {}
def cache_get(url):
    if url not in cache:
        cache[url] = requests.get(url)
        if cache[url].status_code == 404:
            print('\nUsuário não encontrado!\n')
            return None
        elif cache[url].status_code == 403:
            print('\nLimite de chamadas atingido!\n')
            return None

    return cache[url].json()

# Faz a requisição e retorna as informações do usuário informado.
def get_user_info(user):
    return cache_get('https://api.github.com/users/' + user)

# Faz a requisição e retorna as informações dos seguidores do usuário informado.
def get_user_followers(user):
    return cache_get('https://api.github.com/users/' + user + '/followers')

# Faz a requisição e retorna as informações dos repositórios do usuário informado.
def get_user_repos(user):
    return cache_get('https://api.github.com/users/' + user + '/repos')

def main():
    try:
        while True:
            user = input('Digite o nome de usuário: ')
            user_info = get_user_info(user)

            if user_info != None:
                if user_info['name']:
                    print('\nUsuário da consulta: ' + user_info['name'])
                else:
                    print('\nUsuário da consulta: ' + user_info['login'])

                print('\n{} seguidores:\n'.format(user_info['followers']))

                # Informações dos seguidores do usuário.
                for follower in get_user_followers(user):
                    print(get_user_info(follower['login'])['name'])
                    for repo in get_user_repos(follower['login']):
                        print("\t{}".format(repo['name']))
                    print("")
    except:
        pass

if __name__ == '__main__':
    main()