# mirai-mesaga-fonto 
### part of [Mesagisto](https://github.com/MeowCat-Studio/mesagisto)

---


A implementation of message-forwarding-client.
消息转发客户端的 [Telegram](https://core.telegram.org) 实现

___

## Deploy instruction

 1. Get binary file at Release page (or check Actions)
 2. Place it in where network access to Telegram server is stable (you may need HTTP proxy).
 3. Use your favorite editor to create `config.toml` placed with the binary `telegram-mesaga-fonto`.
 here is an example:
 ```toml
# before use, set `enabled` to `true`.
enabled = true

[forwarding]
address = 'nats://itsusinn.site:4222'

[telegram]
# do not forget to fill your bot token before use
token = 'BOT_TOKEN'
bot_name = ''

[proxy]
enabled = false
# you may want to use 'socks5://your_server:port' to use socks5 proxy,
# however, it was not stable at this stage.
address = 'http://127.0.0.1:8889'

[target_address_mapper_storage]
# default empty, manually add is not recommended.
# <chat_id>= '<channel>' (int= 'int')
#
#-11451419 = '10000'
 ```
 4. Start the server:
 ```shell
 $ ./telegram-messaga-fonto
  [INFO] telegram-message-fonto started.	
 ```
 If there are no [ERROR], then you can send `/help` to your bot, with reply:
```text
 信使Bot支持以下命令
 /help - 显示命令帮助
 /enable - 启用消息转发
 /disable - 禁用消息转发
 /setaddress - 设置当前Group的转发地址
 ```
 5. Create a Telegram group, add your bot, and type in the group:

 `/setaddress <channel>`
 
 Here <channel> denotes your qq number.
 
 6. Enjoy.
